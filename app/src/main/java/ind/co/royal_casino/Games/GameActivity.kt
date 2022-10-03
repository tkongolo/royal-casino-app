package ind.co.royal_casino.Games

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowInsets
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.lifecycleScope
import androidx.preference.PreferenceManager
import com.google.android.material.button.MaterialButton
import ind.co.royal_casino.LoginRegister.LoginRegisterActivity
import ind.co.royal_casino.Menu.MainMenuActivity
import ind.co.royal_casino.Menu.wallet.WalletActivity
import ind.co.royal_casino.R
import ind.co.royal_casino.Utilities.BusinessLogic.RequestModels.Resp_GamesResponse
import ind.co.royal_casino.Utilities.Managers.SoundManager
import ind.co.royal_casino.Utilities.Managers.SoundType
import kotlinx.coroutines.launch

open class GameActivity : AppCompatActivity(), BettingPlatformCallback {
    override fun onBetPlatformChange(platform: BetPlatform, coinNumb: Int) {
        TODO("Not yet implemented")
    }

    override fun onCancelBet() {
        TODO("Not yet implemented")
    }

    override fun onBeginBet() {
        TODO("Not yet implemented")
    }


}