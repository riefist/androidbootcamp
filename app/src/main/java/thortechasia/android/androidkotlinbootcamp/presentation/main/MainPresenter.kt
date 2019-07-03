package thortechasia.android.androidkotlinbootcamp.presentation.main

import thortechasia.android.androidkotlinbootcamp.data.response.League
import thortechasia.android.androidkotlinbootcamp.domain.main.MainInteractor

class MainPresenter(val mainInteractor: MainInteractor,
                    val view: MainContract.View) : MainContract.Presenter, MainInteractor.OnLeagueListener {

    init {
        mainInteractor.listener = this
    }

    override fun onLeagueSuccess(leagues: List<League>) {
        view.showLoading(false)
        view.showLeague(leagues)
    }

    override fun onLeagueError(msg: String) {
        view.showLoading(false)
        view.showError(msg)
    }

    override fun getLeague() {
        view.showLoading(true)
        mainInteractor.getRemoteLeagues()
    }
}