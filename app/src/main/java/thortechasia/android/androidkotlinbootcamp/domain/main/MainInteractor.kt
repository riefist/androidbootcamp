package thortechasia.android.androidkotlinbootcamp.domain.main

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import thortechasia.android.androidkotlinbootcamp.data.repository.LeagueRepository
import thortechasia.android.androidkotlinbootcamp.data.response.League

class MainInteractor(val leagueRepository: LeagueRepository) : MainUseCase {

    private val disposables = CompositeDisposable()
    var listener : OnLeagueListener? = null

    override fun getRemoteLeagues() {
        disposables.add(leagueRepository.getRemoteLeagues()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                listener?.onLeagueSuccess(it.leagues)
            },{
                it.message?.let{ msg ->
                    listener?.onLeagueError(msg)
                }
            }))
    }

    override fun getTeams(league: String) {

    }

    interface OnLeagueListener {
        fun onLeagueSuccess(leagues: List<League>)
        fun onLeagueError(msg: String)
    }

}