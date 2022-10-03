package ind.co.royal_casino.Menu.wallet

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fasterxml.jackson.core.type.TypeReference
import com.google.firebase.dynamiclinks.ktx.*
import com.google.firebase.ktx.Firebase
import ind.co.royal_casino.R
import ind.co.royal_casino.Utilities.BusinessLogic.RequestModels.Resp_MainAmountTransaction
import ind.co.royal_casino.Utilities.BusinessLogic.RequestModels.Resp_NewTransactionMain
import ind.co.royal_casino.Utilities.BusinessLogic.RequestModels.Resp_RefreshToken
import ind.co.royal_casino.Utilities.Repositories.Models.MainTransactionType
import ind.co.royal_casino.Utilities.Repositories.UserDetailsRepository
import ind.co.royal_casino.Utilities.isInternetActive
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

enum class StateWallet{
    NORMAL,
    INTERNET_FAIL,
    TOP_UP_SUCCESSFUL,
    TOP_UP_UPDATE_SUCCESSFUL,
    TOP_UP_UPDATE_FAIL,
    TOP_UP_FAIL,
    CLAIM_SUCCESSFUL,
    CLAIM_FAIL,
    LOGOUT,
    SHARE_LINK_SUCC,
    SHARE_LINK_FAIL,
}

class WalletBodyFragmentViewModel(private val ctx: Context) : WalletActivityViewModel(ctx)  {
}