package ind.co.royal_casino.Menu

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fasterxml.jackson.core.type.TypeReference
import ind.co.royal_casino.R
import ind.co.royal_casino.Utilities.BusinessLogic.RequestModels.Resp_RefreshToken
import ind.co.royal_casino.Utilities.Repositories.APIRepository
import ind.co.royal_casino.Utilities.Repositories.AcctMemRepository
import ind.co.royal_casino.Utilities.isInternetActive
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

enum class STATEREGEMAIL{
    NORMAL,
    REGISTERING,
    INTERNET_FAIL,
    LOG_OUT,
    REG_FAIL,
    REG_SUCCESS
}

open class RegistrationViewModel(private val ctx: Context) : ViewModel() {

}