package thortechasia.android.androidkotlinbootcamp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Match(
    var teamA: String,
    var teamB: String,
    var scoreA: Int,
    var scoreB: Int
) : Parcelable