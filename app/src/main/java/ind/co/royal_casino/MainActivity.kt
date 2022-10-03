package ind.co.royal_casino

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import ind.co.royal_casino.LoginRegister.LoginRegisterActivity
import ind.co.royal_casino.Menu.MainMenuActivity
import ind.co.royal_casino.Utilities.ViewModelFactoryWithContext
import ind.co.royal_casino.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //view model
    private lateinit var viewModel: MainViewModel

    private lateinit var TAG: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        TAG = getString(R.string.tag_ui_activity_mainactivity)

        Log.d(TAG,"Build OS Level: ${Build.VERSION.SDK_INT}")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, ViewModelFactoryWithContext(this))[MainViewModel::class.java]

        viewModel.getIntentLoc().observe(this, Observer {
            if(it.equals(IntentLoc.LOGREG)){
                val logIntent = Intent(this, LoginRegisterActivity::class.java)
                startActivity(logIntent)
                finish()
            }else if(it.equals(IntentLoc.MAINMENU)){
                val mainMenuIntent = Intent(this, MainMenuActivity::class.java)
                startActivity(mainMenuIntent)
                finish()
            }
        })

        lifecycleScope.launch {
            viewModel.getRefreshToken()
        }
    }
}