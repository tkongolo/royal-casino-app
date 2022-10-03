package ind.co.royal_casino.Menu.wallet

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.preference.PreferenceManager
import com.google.android.material.snackbar.Snackbar
import com.razorpay.Checkout
import ind.co.royal_casino.LoginRegister.LoginRegisterActivity
import ind.co.royal_casino.Menu.EmailRegCallback
import ind.co.royal_casino.R
import ind.co.royal_casino.Utilities.Managers.SoundManager
import ind.co.royal_casino.Utilities.Managers.SoundType
import ind.co.royal_casino.Utilities.ViewModelFactoryWithContext
import ind.co.royal_casino.databinding.ActivityWalletBinding
import kotlinx.coroutines.launch
import org.json.JSONObject

class WalletActivity : AppCompatActivity(), EmailRegCallback {
    override fun onEmailChange(emailVal: String) {
        TODO("Not yet implemented")
    }
}