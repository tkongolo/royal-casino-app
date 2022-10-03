package ind.co.royal_casino.Menu

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import ind.co.royal_casino.Games.CarRoulette.CarRouletteActivity
import ind.co.royal_casino.Games.ColorSelector.ColorSelectorActivity
import ind.co.royal_casino.Games.DragonVTiger.DragonVsTigerActivity
import ind.co.royal_casino.LoginRegister.LoginRegisterActivity
import ind.co.royal_casino.R
import ind.co.royal_casino.Utilities.ViewModelFactoryWithContext
import ind.co.royal_casino.databinding.ActivityMainMenuBinding

class MainMenuActivity : AppCompatActivity(), EmailRegCallback {
    override fun onEmailChange(emailVal: String) {
        TODO("Not yet implemented")
    }

}