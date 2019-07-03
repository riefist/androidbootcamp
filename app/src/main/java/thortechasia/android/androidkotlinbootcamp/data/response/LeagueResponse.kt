package thortechasia.android.androidkotlinbootcamp.data.response

data class LeagueResponse(
    val leagues: List<League>
)

data class League(
    val idLeague: String,
    val strLeague: String,
    val strLeagueAlternate: String,
    val strSport: String
)