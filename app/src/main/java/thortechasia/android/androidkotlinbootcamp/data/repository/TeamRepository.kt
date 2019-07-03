package thortechasia.android.androidkotlinbootcamp.data.repository

import io.reactivex.Single
import thortechasia.android.androidkotlinbootcamp.data.network.ApiService
import thortechasia.android.androidkotlinbootcamp.data.response.TeamsResponse

class TeamRepository(private val apiService: ApiService) {

    fun getAllTeams(league: String) : Single<TeamsResponse> = apiService.getAllTeams(league)

}