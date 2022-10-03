package ind.co.royal_casino.Games.ColorSelector

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ind.co.royal_casino.R

data class ResultInfoModel(
    var period: String,
    var selectionMade: GameColorSelectorInfo,
    var resultMade: GameColorSelectorInfo
)

data class GameColorSelectorInfo(
    var color: String,
    var number: String
)

class ResultInfoAdapter(private val ctx: Context, private val resultInfoList: ArrayList<ResultInfoModel>) : RecyclerView.Adapter<ResultInfoAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val periodTextView = itemView.findViewById<TextView>(R.id.periodContentText)
        val selectionTextView = itemView.findViewById<TextView>(R.id.selectionContentText)
        val resultTextView = itemView.findViewById<TextView>(R.id.resultContentText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}