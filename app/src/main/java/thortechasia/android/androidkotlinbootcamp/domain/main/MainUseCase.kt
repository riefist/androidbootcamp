package thortechasia.android.androidkotlinbootcamp.domain.main

interface MainUseCase {

    fun getRemoteLeagues()
    fun getTeams(league: String)

}