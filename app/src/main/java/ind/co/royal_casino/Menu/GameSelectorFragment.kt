package ind.co.royal_casino.Menu

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.preference.PreferenceManager
import com.google.android.material.button.MaterialButton
import com.google.android.material.navigation.NavigationView
import ind.co.royal_casino.Menu.aboutUs.AboutUsActivity
import ind.co.royal_casino.Menu.contactUs.ContactUsActivity
import ind.co.royal_casino.Menu.privacyPolicy.PrivacyPolicyActivity
import ind.co.royal_casino.Menu.refund.RefundActivity
import ind.co.royal_casino.Menu.wallet.WalletActivity
import ind.co.royal_casino.R
import ind.co.royal_casino.Utilities.Activities.SettingsActivity
import ind.co.royal_casino.Utilities.Managers.SoundManager
import ind.co.royal_casino.Utilities.Managers.SoundType
import ind.co.royal_casino.Utilities.Repositories.Models.GameType
import ind.co.royal_casino.Utilities.ViewModelFactoryWithContext
import ind.co.royal_casino.Utilities.getInternetFailureDialog
import ind.co.royal_casino.Utilities.getProcessAlert
import ind.co.royal_casino.databinding.FragmentGameSelectorBinding
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [GameSelectorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameSelectorFragment : Fragment() {

}