package thortechasia.android.androidkotlinbootcamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_score.*

class ScoreActivity : AppCompatActivity() {
    // variable untuk menyimpan data score sementara
    private var scoreA = 0
    private var scoreB = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val teamA = intent.getStringExtra(EXTRA_TEAM_A)
        val teamB = intent.getStringExtra(EXTRA_TEAM_B)

        txt_nama_team_a.text = teamA
        txt_nama_team_b.text = teamB

        teamAButtonListener()

    }

    fun plus3PointTeamA(view: View){
        scoreA += 3
        txt_score_a.text = "$scoreA"
    }

    fun plus2PointTeamA(view: View){
        scoreA += 2
        txt_score_a.text = "$scoreA"
    }

    fun freeThrowTeamA(view: View){
        scoreA += 1
        txt_score_a.text = "$scoreA"

    }

    fun resetScore(view: View){
        scoreA = 0
        scoreB = 0
        txt_score_a.text = "$scoreA"
        txt_score_b.text = "$scoreB"
    }

    private fun teamAButtonListener(){
        btn_plus3_team_b.setOnClickListener {
            scoreB += 3
            txt_score_b.text = "$scoreB"
        }

        btn_plus2_team_b.setOnClickListener {
            scoreB += 1
            txt_score_b.text = "$scoreB"
        }

        btn_freethrow_team_b.setOnClickListener {
            scoreB += 1
            txt_score_b.text = "$scoreB"
        }
    }
}
