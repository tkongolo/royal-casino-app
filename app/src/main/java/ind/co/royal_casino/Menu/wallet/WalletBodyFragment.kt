package ind.co.royal_casino.Menu.wallet

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.preference.PreferenceManager
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.razorpay.PaymentData
import com.razorpay.PaymentResultWithDataListener
import ind.co.royal_casino.LoginRegister.LoginRegisterActivity
import ind.co.royal_casino.Menu.EmailRegistrationDialog
import ind.co.royal_casino.Menu.STATEREGEMAIL
import ind.co.royal_casino.R
import ind.co.royal_casino.Utilities.Managers.SoundManager
import ind.co.royal_casino.Utilities.Managers.SoundType
import ind.co.royal_casino.Utilities.Repositories.Models.MainTransactionType
import ind.co.royal_casino.Utilities.ViewModelFactoryWithContext
import ind.co.royal_casino.Utilities.getInternetFailureDialog
import ind.co.royal_casino.Utilities.getProcessAlert
import ind.co.royal_casino.databinding.FragmentWalletBodyBinding
import kotlinx.coroutines.launch
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 * Use the [WalletBodyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WalletBodyFragment : Fragment(), PaymentResultWithDataListener {
    override fun onPaymentSuccess(p0: String?, p1: PaymentData?) {
        TODO("Not yet implemented")
    }

    override fun onPaymentError(p0: Int, p1: String?, p2: PaymentData?) {
        TODO("Not yet implemented")
    }

}