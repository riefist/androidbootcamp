package thortechasia.android.androidkotlinbootcamp.di

import org.koin.dsl.module
import thortechasia.android.androidkotlinbootcamp.data.repository.LeagueRepository

val repositoryModule = module {

    single { LeagueRepository(get()) }

}