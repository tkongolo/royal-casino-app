package ind.co.royal_casino.LoginRegister.login

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fasterxml.jackson.core.type.TypeReference
import com.google.firebase.messaging.FirebaseMessaging
import ind.co.royal_casino.R
import ind.co.royal_casino.Utilities.BusinessLogic.RequestModels.Resp_LoginToken
import ind.co.royal_casino.Utilities.Repositories.APIRepository
import ind.co.royal_casino.Utilities.Repositories.AcctMemRepository
import ind.co.royal_casino.Utilities.isInternetActive
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

enum class STATELOGGING{
    NORMAL,
    INTERNET_FAIL,
    LOG_FAIL,
    LOG_SUCCESS
}

class LoginFragmentViewModels(private val ctx: Context) : ViewModel() {

}