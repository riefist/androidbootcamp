package thortechasia.android.androidkotlinbootcamp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row_match.view.*

// untuk mengelola data set kedalam recyclerview
class MatchAdapter(private val matchs: List<Match>) : RecyclerView.Adapter<MatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_match, parent, false)
        return MatchViewHolder(view)
    }

    override fun getItemCount(): Int = matchs.size

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bindItem(matchs[position])
    }
}
// untuk membinding data ke tiap2 item list object match
class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindItem(match: Match) = with(itemView){
        teamA.text = match.teamA + " ${match.scoreA}"// Chicago bulls (100)
        teamB.text = "${match.scoreB} " +match.teamB // (100) Chicago bulls
    }

}