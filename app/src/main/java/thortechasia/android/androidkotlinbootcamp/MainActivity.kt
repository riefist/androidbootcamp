package thortechasia.android.androidkotlinbootcamp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private lateinit var matchAdapter : MatchAdapter

    private val matchs = mutableListOf<Match>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        matchAdapter = MatchAdapter(matchs)

        rv_matchs.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = matchAdapter
        }


        btn_match_begin.setOnClickListener {
            //Todo pindah kehalaman score dengan membawa nama team A dan team
            val namaTeamA = edt_team_a.text.toString()
            val namaTeamB = edt_team_b.text.toString()

            if (!validation(namaTeamA, namaTeamB)) return@setOnClickListener

            //create instance object Match
            val match = Match(namaTeamA, namaTeamB, 0, 0)

            // starting activity with we need some result
            startActivityForResult<ScoreActivity>(
                RC_SCORE_MATCH,
                EXTRA_MATCH to match
            )
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RC_SCORE_MATCH && resultCode == Activity.RESULT_OK){

            data?.let {
                // if not null will be executed
                val match = it.getParcelableExtra<Match>(EXTRA_MATCH)
                //add match to list match
                matchs.add(match)
                //then notify adapter
                matchAdapter.notifyDataSetChanged()

            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }


    private fun validation(namaTeamA: String, namaTeamB: String): Boolean {
        var result = true
        if (namaTeamA.isEmpty()) {
            edt_team_a.error = "Gk boleh kosong"
            result = false
        } else {
            edt_team_a.error = null
        }
        if (namaTeamB.isEmpty()) {
            edt_team_b.error = "Gk boleh kosong"
            result = false
        } else {
            edt_team_b.error = null
        }

        return result
    }
}
