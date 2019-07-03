package thortechasia.android.androidkotlinbootcamp.presentation.main

import thortechasia.android.androidkotlinbootcamp.data.response.League

interface MainContract {

    interface View {

        fun showLoading(isShow: Boolean)
        fun showLeague(leagues: List<League>)
        fun showError(message: String)

    }

    interface Presenter {
        fun getLeague()
    }

}