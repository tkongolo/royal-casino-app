package ind.co.royal_casino.Menu.wallet

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fasterxml.jackson.core.type.TypeReference
import ind.co.royal_casino.Menu.RegistrationViewModel
import ind.co.royal_casino.R
import ind.co.royal_casino.Utilities.BusinessLogic.RequestModels.Resp_RefreshToken
import ind.co.royal_casino.Utilities.BusinessLogic.RequestModels.Resp_SummaryProfile
import ind.co.royal_casino.Utilities.Repositories.UserDetailsRepository
import ind.co.royal_casino.Utilities.isInternetActive
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

enum class WALLACTIVSTATE{
    NORMAL,
    LOGOUT,
    SUCC,
    FAIL
}

open class WalletActivityViewModel(private val ctx: Context) : RegistrationViewModel(ctx) {

}