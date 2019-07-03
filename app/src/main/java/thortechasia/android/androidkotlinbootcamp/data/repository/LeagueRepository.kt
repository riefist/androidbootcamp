package thortechasia.android.androidkotlinbootcamp.data.repository

import io.reactivex.Single
import thortechasia.android.androidkotlinbootcamp.data.network.ApiService
import thortechasia.android.androidkotlinbootcamp.data.response.LeagueResponse

class LeagueRepository(val apiService: ApiService) {

    fun getRemoteLeagues() : Single<LeagueResponse> = apiService.getAllLeagues()

}