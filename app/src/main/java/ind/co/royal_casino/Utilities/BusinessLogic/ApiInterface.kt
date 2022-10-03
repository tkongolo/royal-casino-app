package ind.co.royal_casino.Utilities.BusinessLogic

import ind.co.royal_casino.Utilities.BusinessLogic.RequestModels.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface ApiInterface {
    @POST("players/login")
    fun getLoginCred(@Body loginDet: Body_Login): Call<String>

    @GET("players/{playerID}/summary")
    fun getProfile(@Header("Authorization") bearerToken: String,
                   @Path("playerID") playerID: Int): Call<String>

    @PATCH("players/{playerID}/device/update")
    fun updatePlayerDevice(@Header("Authorization") bearerToken: String,
                           @Path("playerID") playerID: Int,
                           @Body devInfo: Body_DeviceUpdate
    ): Call<String>

    @POST("players")
    fun registerNewPlayer(@Body registerDet: Body_RegisterInfo): Call<String>

    @PATCH("players/{playerID}")
    fun updatePlayerEmail(@Header("Authorization")bearerToken: String,
                          @Path("playerID") playerID: Int,
                          @Body emailInfo: Body_PlayerUpdate
    ): Call<String>

    @POST("players/refresh")
    fun refrestAccessToken(@Body refreshTok: Body_Refresh): Call<String>

//    @POST("player/accounts/vcoins/transact")
//    fun performMainTransaction(@Header("Authorization") bearerToken: String,
//                               @Body mainTransDto: Body_MainTransaction): Call<String>
    @POST("players/{playerID}/transactions/topups")
    fun performTopUpTransaction(@Header("Authorization") bearerToken: String,
                                @Path("playerID") playerID: Int,
                                @Body mainTransDto: Body_NewMainTransaction): Call<String>

    @POST("players/{playerID}/transactions/claims")
    fun performClaimTransaction(@Header("Authorization") bearerToken: String,
                                @Path("playerID") playerID: Int,
                                @Body mainTransDto: Body_NewMainTransaction): Call<String>

    @POST("player/accounts/vcoins/payment/topup")
    fun performTopupUpdate(@Header("Authorization")bearerToken: String,
                           @Body updateTransDto: Body_RazorSuccessTransaction): Call<String>

    @GET("documentation")
    fun getDocumentation(@Query("doctype") docType: String): Call<String>

    @GET("games/{gameName}/bet")
    fun performGameBet(@Header("Authorization")bearerToken: String,
                       @Path("gameName")gameNameVal: String,
                       @Query("amount")amountVal: Int,
                       @Query("choice")choiceVal: String) : Call<String>

    companion object{
        var BASE_URL = "http://104.197.73.203:8000/api/royal-casino/"
        //var BASE_URL = " https://4cb7-197-232-61-235.ap.ngrok.io/api/royal-casino/"

        var httpClient = OkHttpClient.Builder()
            .connectTimeout(90, TimeUnit.SECONDS)
            .readTimeout(90, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS).build()

        fun create(): ApiInterface{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(httpClient)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}