package ind.co.royal_casino.Utilities.Services

import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.AudioFocusRequest
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.util.Log
import androidx.preference.PreferenceManager
import ind.co.royal_casino.R

class GameMusicService: Service(), AudioManager.OnAudioFocusChangeListener {
    private var mediaPlayer: MediaPlayer? = null
    private lateinit var audioManager: AudioManager
    private lateinit var audioRequest: AudioFocusRequest
    private val iBinder: IBinder = LocalBinder()
    private var gameType: String? = null

    override fun onBind(intent: Intent): IBinder {
        return iBinder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val extraInfo = intent?.extras
        if(extraInfo == null){
            Log.d("GameMusicService","No extra info. Have to stop")
            stopSelf()
        }

        if(!requestAudioFocus()){
            Log.d("GameMusicService","Request audio focus failed. Have to stop")
            stopSelf()
        }


        val musicType = extraInfo?.getString("music_type")
        if(musicType == "menu"){
            gameType = "menu"
            mediaPlayer = MediaPlayer.create(applicationContext, R.raw.music_main_lobby)
        }else if(musicType == "game"){
            gameType = "game"
            mediaPlayer = MediaPlayer.create(applicationContext,R.raw.slot_machine_music)
        }else{
            Log.d("GameMusicService","Will not start no music type specified")
        }

        mediaPlayer?.isLooping = true

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        if(mediaPlayer != null){
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
        }
        removeAudioFocus()
    }

    private fun allowVolume(): Boolean{
        val gameSettings = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val musicSetting: Boolean = gameSettings.getBoolean("music",true)
        return musicSetting
    }

    override fun onAudioFocusChange(p0: Int) {
        when(p0){
            AudioManager.AUDIOFOCUS_GAIN -> {
                Log.d("GameMusicService","Audio focus gain mode")
                if(mediaPlayer == null){
                    Log.d("GameMusicService","Media player is null")
                    Log.d("GameMusicService","Creating media player")
                    if(gameType == null || gameType == "menu"){
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.music_main_lobby)
                    }else{
                        mediaPlayer = MediaPlayer.create(applicationContext,R.raw.slot_machine_music)
                    }
                    Log.d("GameMusicService","Media player created")
                    mediaPlayer?.isLooping = true
                }

                if(mediaPlayer?.isPlaying == false){
                    Log.d("GameMusicService","Media not playing. Going to start playing")
                    mediaPlayer?.start()
                    Log.d("GameMusicService","Media player started")
                }
                if(allowVolume()){
                    Log.d("GameMusicService","Volume is allowed. Going to be high")
                    mediaPlayer?.setVolume(1.0f,1.0f)
                }else{
                    Log.d("GameMusicService","Volume is low")
                    mediaPlayer?.setVolume(0.0f,0.0f)
                }

            }

            AudioManager.AUDIOFOCUS_LOSS -> {
                Log.d("GameMusicService","Audio focus loss")
                if(mediaPlayer?.isPlaying == true){
                    mediaPlayer?.stop()
                    Log.d("GameMusicService","Media player stopped")
                }
                mediaPlayer?.release()
            }

            AudioManager.AUDIOFOCUS_LOSS_TRANSIENT -> {
                Log.d("GameMusicService","Audio focus transient")
                if(mediaPlayer?.isPlaying == true){
                    mediaPlayer?.pause()
                    Log.d("GameMusicService","Media player is paused")
                }

            }

            AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK -> {
                if(mediaPlayer?.isPlaying == true){
                    Log.d("GameMusicService","Audio focus transient can duck")
                    mediaPlayer?.setVolume(0.0f,0.0f)
                    Log.d("GameMusicService","Media player volume set low")
                }

            }

        }
    }

    private fun requestAudioFocus(): Boolean{
        audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .build()
        audioRequest = AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN)
            .setAudioAttributes(audioAttributes)
            .setAcceptsDelayedFocusGain(true)
            .setWillPauseWhenDucked(true)
            .setOnAudioFocusChangeListener(this)
            .build()
        val result = audioManager.requestAudioFocus(audioRequest)
        if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
            Log.d("GameMusicService","Request audio focus successful")
            return true
        }
        Log.d("GameMusicService","Request audio focus not successful")
        return false
    }

    private fun removeAudioFocus(): Boolean{
        Log.d("GameMusicService","Going to remove audio focus")
        return AudioManager.AUDIOFOCUS_REQUEST_GRANTED == audioManager.abandonAudioFocusRequest(audioRequest)
    }

    inner class LocalBinder : Binder() {
        fun getService(): GameMusicService? {
            return this@GameMusicService
        }
    }
}