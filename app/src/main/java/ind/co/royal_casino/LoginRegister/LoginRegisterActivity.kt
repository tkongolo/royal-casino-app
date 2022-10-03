package ind.co.royal_casino.LoginRegister

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase
import ind.co.royal_casino.LoginRegister.login.LoginFragment
import ind.co.royal_casino.LoginRegister.signup.SignupFragment
import ind.co.royal_casino.R
import ind.co.royal_casino.databinding.ActivityLoginRegisterBinding
import kotlinx.coroutines.launch

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, invitedBy: String?) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private var deepLinkVar: String? = invitedBy

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if(position == 0){
            LoginFragment()
        }else{
            val resp = SignupFragment()
            var viewBundle = Bundle()
            viewBundle.putString("invited_by",deepLinkVar)
            resp.arguments = viewBundle
            resp
        }
    }
}

class LoginRegisterActivity : AppCompatActivity() {

}