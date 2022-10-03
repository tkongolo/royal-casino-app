package ind.co.royal_casino.Games.ColorSelector

import android.content.Context
import ind.co.royal_casino.Games.GameStates
import ind.co.royal_casino.Games.GameViewModels
import ind.co.royal_casino.R
import ind.co.royal_casino.Utilities.Repositories.Models.GameType

enum class ColorSelectorBet{
    GREEN,
    VIOLET,
    RED,
    INIT
}

class ColorSelectorActivityViewModels(private val ctx: Context): GameViewModels(ctx){

}