package thortechasia.android.androidkotlinbootcamp.data.network

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import thortechasia.android.androidkotlinbootcamp.external.ALL_LEAGUES_ENDPOINT
import thortechasia.android.androidkotlinbootcamp.data.response.LeagueResponse
import thortechasia.android.androidkotlinbootcamp.data.response.TeamsResponse
import thortechasia.android.androidkotlinbootcamp.external.ALL_TEAMS_IN_A_LEAGUE_ENDPOINT

interface ApiService {

    @GET(ALL_LEAGUES_ENDPOINT)
    fun getAllLeagues() : Single<LeagueResponse>

    @GET(ALL_TEAMS_IN_A_LEAGUE_ENDPOINT)
    fun getAllTeams(@Query("l") l: String) : Single<TeamsResponse>

}