package ind.co.royal_casino.Menu

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fasterxml.jackson.core.type.TypeReference
import ind.co.royal_casino.R
import ind.co.royal_casino.Utilities.BusinessLogic.RequestModels.Resp_RefreshToken
import ind.co.royal_casino.Utilities.BusinessLogic.RequestModels.Resp_SummaryProfile
import ind.co.royal_casino.Utilities.Repositories.Models.GameType
import ind.co.royal_casino.Utilities.isInternetActive
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

enum class MainMenuState{
    NO_LOG_OUT,
    LOG_OUT,
    CHECKING_AMOUNT,
    GAME_Dragon_V_Tiger,
    GAME_Color_Selector,
    GAME_Slot_Machine,
    GAME_Car_Roulette,
    API_ERROR
}

class MainMenuActivityViewModel(private val ctx: Context): RegistrationViewModel(ctx) {

}