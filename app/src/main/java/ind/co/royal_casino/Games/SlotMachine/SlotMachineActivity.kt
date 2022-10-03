package ind.co.royal_casino.Games.SlotMachine

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ind.co.royal_casino.Utilities.Managers.SoundManager
import ind.co.royal_casino.Utilities.ViewModelFactoryWithContext

class SlotMachineActivity: AppCompatActivity() {
    private lateinit var viewModels: SlotMachineViewModels
    private lateinit var soundManager: SoundManager
    private var musicAllowed: Boolean = false
    private var gameSoundsAllowed: Boolean = false

    fun onCreate(){

        viewModels = ViewModelProvider(this,
            ViewModelFactoryWithContext(this)
        )[SlotMachineViewModels::class.java]

        initializeData()

    }

    private fun startMusicService(){

    }

    private fun initializeData(){
        val extraInfo = intent.extras
        if(extraInfo != null){
            val amtFloat = extraInfo.getFloat("available_balance")
            viewModels.setWalletAmount(amtFloat)
            val musicVal = extraInfo.getBoolean("music_allowed")
            val gameVal = extraInfo.getBoolean("game_sounds_allowed")
            musicAllowed = musicVal
            gameSoundsAllowed = gameVal

        }
    }

    override fun onBackPressed() {
        finish()
    }

}