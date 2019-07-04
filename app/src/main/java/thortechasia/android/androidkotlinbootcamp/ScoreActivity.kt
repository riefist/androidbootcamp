package thortechasia.android.androidkotlinbootcamp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_score.*

class ScoreActivity : AppCompatActivity() {
    // variable untuk menyimpan data score sementara
    private var scoreA = 0
    private var scoreB = 0

    private lateinit var match: Match

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

//        val teamA = intent.getStringExtra(EXTRA_TEAM_A)
//        val teamB = intent.getStringExtra(EXTRA_TEAM_B)

        // get object match from main activity
        match = intent.getParcelableExtra(EXTRA_MATCH)

        txt_nama_team_a.text = match.teamA
        txt_nama_team_b.text = match.teamB

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

    fun saveScoreData(view: View){
        //TODO kirim result object match ke halaman main activity

        match.scoreA = scoreA
        match.scoreB = scoreB

        val intent = Intent().putExtra(EXTRA_MATCH, match)

        setResult(Activity.RESULT_OK, intent)
        finish()
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
