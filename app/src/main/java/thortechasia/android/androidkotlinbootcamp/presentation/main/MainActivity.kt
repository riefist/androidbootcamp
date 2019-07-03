package thortechasia.android.androidkotlinbootcamp.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import thortechasia.android.androidkotlinbootcamp.R
import thortechasia.android.androidkotlinbootcamp.data.network.ApiClient
import thortechasia.android.androidkotlinbootcamp.data.network.ApiService
import thortechasia.android.androidkotlinbootcamp.data.response.League
import thortechasia.android.androidkotlinbootcamp.data.response.LeagueResponse
import thortechasia.android.androidkotlinbootcamp.external.gone
import thortechasia.android.androidkotlinbootcamp.external.visible

class MainActivity : AppCompatActivity(), MainContract.View {

    private val presenter : MainPresenter by inject { parametersOf(this) }

    private val leaguesName = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.getLeague()

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                toast(leaguesName[position])
            }

        }

    }

    override fun showLoading(isShow: Boolean) {
        if (isShow) progressBar.visible() else progressBar.gone()
    }

    override fun showLeague(leagues: List<League>) {
        leagues.forEach {
            leaguesName.add(it.strLeague)
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, leaguesName)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    override fun showError(message: String) {
        toast(message)
    }



}
