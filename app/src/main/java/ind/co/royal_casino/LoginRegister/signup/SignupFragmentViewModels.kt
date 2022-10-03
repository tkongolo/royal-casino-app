package ind.co.royal_casino.LoginRegister.signup

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.messaging.FirebaseMessaging
import ind.co.royal_casino.R
import ind.co.royal_casino.Utilities.Repositories.APIRepository
import ind.co.royal_casino.Utilities.isInternetActive
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

enum class STATEREGISTER{
    NORMAL,
    INTERNET_FAIL,
    REG_FAIL,
    REG_SUCCESS
}

class SignupFragmentViewModels(private val ctx: Context) : ViewModel() {

}