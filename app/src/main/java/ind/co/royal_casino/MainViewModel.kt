package ind.co.royal_casino

import android.content.Context
import androidx.lifecycle.*
import ind.co.royal_casino.Utilities.Repositories.AcctMemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

enum class IntentLoc {
    LOGREG,
    MAINMENU,
    NONE
}

class MainViewModel(private val ctx: Context): ViewModel() {
    private val _intentLoc = MutableLiveData<IntentLoc>()

    private val acctRepo: AcctMemRepository = AcctMemRepository(ctx)

    init {
        _intentLoc.value = IntentLoc.NONE
    }

    fun getIntentLoc(): LiveData<IntentLoc>{
        return _intentLoc
    }

    suspend fun getRefreshToken(){
        return withContext(Dispatchers.IO){
            val refTok: String? = acctRepo.getRefToken()
            if(refTok.isNullOrEmpty()){
                _intentLoc.postValue(IntentLoc.LOGREG)
            }else{
                _intentLoc.postValue(IntentLoc.MAINMENU)
            }
        }
    }
}