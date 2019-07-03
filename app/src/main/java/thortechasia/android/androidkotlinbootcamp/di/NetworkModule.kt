package thortechasia.android.androidkotlinbootcamp.di

import org.koin.dsl.module
import thortechasia.android.androidkotlinbootcamp.data.network.ApiClient

val networkModule = module {
    single { ApiClient.provideOkHttpClient() }
    single { ApiClient.create(get()) }

}