package thortechasia.android.androidkotlinbootcamp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_match_begin.setOnClickListener {
            //Todo pindah kehalaman score dengan membawa nama team A dan team

            val namaTeamA = edt_team_a.text.toString()
            val namaTeamB= edt_team_b.text.toString()

            if (!validation(namaTeamA, namaTeamB)) return@setOnClickListener

            startActivity<ScoreActivity>(
                EXTRA_TEAM_A to namaTeamA,
                EXTRA_TEAM_B to namaTeamB
            )

            toast("$namaTeamA vs $namaTeamB match begin")

        }

    }

    private fun validation(namaTeamA: String, namaTeamB: String) : Boolean {
        var result = true
        if (namaTeamA.isEmpty()){
            edt_team_a.error = "Gk boleh kosong"
            result = false
        } else {
            edt_team_a.error = null
        }
        if (namaTeamB.isEmpty()){
            edt_team_b.error = "Gk boleh kosong"
            result = false
        } else {
            edt_team_b.error = null
        }

        return result
    }
}
