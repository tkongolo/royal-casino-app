package ind.co.royal_casino.Games.ColorSelector

import android.app.Activity
import android.app.AlertDialog
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import ind.co.royal_casino.Games.GameActivity
import ind.co.royal_casino.R
import ind.co.royal_casino.Utilities.BusinessLogic.RequestModels.Resp_GamesResponse
import ind.co.royal_casino.Utilities.Managers.SoundType
import ind.co.royal_casino.Utilities.ViewModelFactoryWithContext
import ind.co.royal_casino.Utilities.getNowDateTimeForColorSelector
import ind.co.royal_casino.databinding.ActivityColorSelectorBinding
import ind.co.royal_casino.databinding.DialogGameColorselectorResultBinding
import java.util.ArrayList

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class ColorSelectorActivity : GameActivity() {

}