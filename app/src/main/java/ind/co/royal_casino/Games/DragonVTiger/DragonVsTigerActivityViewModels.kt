package ind.co.royal_casino.Games.DragonVTiger

import android.content.Context
import ind.co.royal_casino.Games.GameStates
import ind.co.royal_casino.Games.GameViewModels
import ind.co.royal_casino.R
import ind.co.royal_casino.Utilities.Repositories.Models.GameType

enum class DvtSelectedBet{
    DRAGON,
    TIGER,
    DRAW,
    INIT
}

enum class Game_DragonVTiger_Result{
    DRAGON,
    DRAW,
    TIGER
}

class DragonVsTigerActivityViewModels(private val ctx: Context): GameViewModels(ctx) {

}