package ind.co.royal_casino.Utilities.Managers

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import ind.co.royal_casino.R

class SoundManager(private val ctx: Context) {
    private var soundPool: SoundPool
    //sounds
    private var normbuttonClick = -1
    private var gameBetClick = -1
    private var gameCancelClick = -1
    private var gameDealClick = -1
    private var gameWinningCelebration = -1
    private var gameBetSelect = -1
    private var gameCoinPush = -1
    private var gamePopup = -1
    private var gameBetProcess = -1
    private var gameCarRouletteCarHit = -1

    init {
        val attrs: AudioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        soundPool = SoundPool.Builder()
            .setMaxStreams(10)
            .setAudioAttributes(attrs)
            .build()

        normbuttonClick = soundPool.load(ctx, R.raw.button_click,1)
        gameBetClick = soundPool.load(ctx, R.raw.bet,1)
        gameCancelClick = soundPool.load(ctx, R.raw.hit,1)
        gameDealClick = soundPool.load(ctx, R.raw.spin,1)
        gameWinningCelebration = soundPool.load(ctx, R.raw.box_bouns_result,1)
        gameBetSelect = soundPool.load(ctx, R.raw.callback_succes,1)
        gameCoinPush = soundPool.load(ctx, R.raw.coin_push,1)
        gamePopup = soundPool.load(ctx, R.raw.popup,1)
        gameBetProcess = soundPool.load(ctx, R.raw.reel_spin,1)
        gameCarRouletteCarHit = soundPool.load(ctx, R.raw.winning,1)
    }

    fun playSound(soundType: SoundType): Int{
        return when(soundType){
            SoundType.NORM_BUTTON_CLICK -> soundPool.play(normbuttonClick,1.0f,1.0f,1,0,1.0f)
            SoundType.GAME_BET_CLICK ->soundPool.play(gameBetClick,1.0f,1.0f,1,0,1.0f)
            SoundType.GAME_CANCEL_CLICK -> soundPool.play(gameCancelClick,1.0f,1.0f,1,0,1.0f)
            SoundType.GAME_DEAL_CLICK -> soundPool.play(gameDealClick,1.0f,1.0f,1,0,1.0f)
            SoundType.GAME_WINNING_CELEB -> soundPool.play(gameWinningCelebration,1.0f,1.0f,1,0,1.0f)
            SoundType.GAME_BET_SELECT -> soundPool.play(gameBetSelect,1.0f,1.0f,1,0,1.0f)
            SoundType.GAME_COIN_PUSH -> soundPool.play(gameCoinPush,1.0f,1.0f,1,0,1.0f)
            SoundType.GAME_POPUP -> soundPool.play(gamePopup,1.0f,1.0f,1,0,1.0f)
            SoundType.GAME_BET_PROCESS -> soundPool.play(normbuttonClick,1.0f,1.0f,1,1,1.0f)
            SoundType.GAME_CAR_ROULETTE_CAR_HIT -> soundPool.play(gameCarRouletteCarHit,1.0f,1.0f,1,0,1.0f)
        }
    }

    fun stopSound(soundID: Int){
        soundPool.stop(soundID)
    }
}