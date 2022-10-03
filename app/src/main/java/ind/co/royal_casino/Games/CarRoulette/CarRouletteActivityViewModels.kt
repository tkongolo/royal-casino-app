package ind.co.royal_casino.Games.CarRoulette

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ind.co.royal_casino.Games.GameStates
import ind.co.royal_casino.Games.GameViewModels
import ind.co.royal_casino.R
import ind.co.royal_casino.Utilities.Repositories.Models.GameType

enum class CRouletteSelectedBet{
    MAZERRATI,
    FERRARI,
    LAMBORGHINI,
    PORSCHE,
    BMW,
    BENZ,
    JAGUAR,
    LANDROVER,
    INIT
}

enum class RouletteState{
    INIT,
    RUNNING,
    STOP
}

enum class Game_CarRoulette_Result{
    MAZERRATI,
    FERRARI,
    LAMBORGHINI,
    PORSCHE,
    BMW,
    BENZ,
    JAGUAR,
    LANDROVER,
}

class CarRouletteActivityViewModels(private val ctx: Context): GameViewModels(ctx) {

}