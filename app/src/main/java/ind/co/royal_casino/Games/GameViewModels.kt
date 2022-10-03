package ind.co.royal_casino.Games

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fasterxml.jackson.core.type.TypeReference
import ind.co.royal_casino.R
import ind.co.royal_casino.Utilities.BusinessLogic.RequestModels.Resp_GamesResponse
import ind.co.royal_casino.Utilities.BusinessLogic.RequestModels.Resp_RefreshToken
import ind.co.royal_casino.Utilities.Repositories.APIRepository
import ind.co.royal_casino.Utilities.Repositories.AcctMemRepository
import ind.co.royal_casino.Utilities.Repositories.Models.GameType
import ind.co.royal_casino.Utilities.isInternetActive
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

enum class GameStates{
    NORMAL,
    PROCESS_BETTING,
    BET_CHECKER_FAIL,
    BETTING_FAIL,
    LOGOUT
}

enum class BetPlatform{
    INIT,
    COIN_SELECTOR,
    MAIN,
    NEW_MAIN
}

open class GameViewModels(private val ctx: Context) : ViewModel() {

}