package thortechasia.android.androidkotlinbootcamp.di

import org.koin.dsl.module
import thortechasia.android.androidkotlinbootcamp.presentation.main.MainContract
import thortechasia.android.androidkotlinbootcamp.presentation.main.MainPresenter

val presenterModule = module {
    single { (view: MainContract.View) -> MainPresenter(get(), view) }
}