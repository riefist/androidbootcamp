package thortechasia.android.androidkotlinbootcamp.di

import org.koin.dsl.module
import thortechasia.android.androidkotlinbootcamp.domain.main.MainInteractor
import thortechasia.android.androidkotlinbootcamp.domain.main.MainUseCase

val interactorModule = module {

    single { MainInteractor(get()) }

}