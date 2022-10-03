package ind.co.royal_casino


import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.fasterxml.jackson.core.type.TypeReference
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import ind.co.royal_casino.Utilities.BusinessLogic.RequestModels.Resp_RefreshToken
import ind.co.royal_casino.Utilities.Repositories.APIRepository
import ind.co.royal_casino.Utilities.Repositories.AcctMemRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MessageNotificationService : FirebaseMessagingService() {

    private lateinit var acctApi : APIRepository
    private lateinit var acctMem: AcctMemRepository
    private lateinit var TAG: String

    override fun onNewToken(token: String) {
        acctApi = APIRepository(applicationContext)
        acctMem = AcctMemRepository(applicationContext)
        TAG = applicationContext.getString(R.string.tag_ui_service_messagenotificationservice)

        val resp = acctApi.executeUpdateDeviceToken(token)
        resp.enqueue(object : Callback<String?> {
            override fun onResponse(call: Call<String?>, response: Response<String?>) {
                when (response.code()) {
                    401 -> {
                        //do refresh token
                        val refreshResp = acctApi.executeRefreshAccessToken()
                        refreshResp.enqueue(object: Callback<String?> {
                            override fun onResponse(
                                call: Call<String?>,
                                response: Response<String?>
                            ) {
                                when (response.code()) {
                                    401 -> {
                                        Log.e(
                                            TAG,
                                            applicationContext.getString(R.string.API_MSG_unauthorized)
                                        )
                                    }
                                    404 -> {
                                        Log.e(
                                            TAG,
                                            applicationContext.getString(R.string.API_MSG_noPlayer)
                                        )
                                    }
                                    500 -> {
                                        Log.e(
                                            TAG,
                                            applicationContext.getString(R.string.API_MSG_internalServerErr)
                                        )
                                    }
                                    201 -> {
                                        val respString = response.body()
                                        if (!respString.isNullOrEmpty()) {
                                            try {
                                                val respTok: Resp_RefreshToken? =
                                                    acctApi.objectMapper.readValue(respString,
                                                        object :
                                                            TypeReference<Resp_RefreshToken?>() {})
                                                acctMem.saveAccToken(respTok!!.access_token)
                                            } catch (ex: Exception) {
                                                Log.e(
                                                    TAG,
                                                    "${applicationContext.getString(R.string.LOG_MSG_ERR_internalError)}: ${ex.message}"
                                                )

                                            }
                                        } else {
                                            Log.e(
                                                TAG,
                                                applicationContext.getString(R.string.LOG_MSG_ERR_internalError)
                                            )
                                        }
                                    }
                                }
                            }

                            override fun onFailure(call: Call<String?>, t: Throwable) {
                                Log.e(
                                    TAG,
                                    "${applicationContext.getString(R.string.LOG_MSG_ERR_internalError)}: ${t.message}"
                                )
                            }
                        })
                    }

                    500 -> {
                        Log.e(
                            TAG,
                            applicationContext.getString(R.string.API_MSG_internalServerErr)
                        )
                    }

                }
            }

            override fun onFailure(call: Call<String?>, t: Throwable) {
                Log.e(TAG,"${applicationContext.getString(R.string.LOG_MSG_ERR_internalError)}: ${t.message}")

            }

        })
    }

    override fun onMessageReceived(message: RemoteMessage) {
        TAG = applicationContext.getString(R.string.tag_ui_service_messagenotificationservice)

        if(message.data.isNotEmpty()){
            val notificationTitle = message.data["not_title"]
            val notificationMsg = message.data["not_body"]
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            val pendingIntent = PendingIntent.getActivity(applicationContext, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT)
//
            val channelId = getString(R.string.channel_messages)
            val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val notificationBuilder = NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_logo_phone)
                .setContentTitle(notificationTitle)
                .setContentText(notificationMsg)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setVibrate(longArrayOf(1000,1000,1000,1000))
                .setOnlyAlertOnce(true)
                .setContentIntent(pendingIntent)

//
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            // Since android Oreo notification channel is needed.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(channelId,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT)
                notificationManager.createNotificationChannel(channel)
            }

            notificationManager.notify(0 /* ID of notification */, notificationBuilder.build())
        }
    }


}