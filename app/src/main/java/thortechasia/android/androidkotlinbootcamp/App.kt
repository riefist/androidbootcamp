package thortechasia.android.androidkotlinbootcamp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import thortechasia.android.androidkotlinbootcamp.di.interactorModule
import thortechasia.android.androidkotlinbootcamp.di.networkModule
import thortechasia.android.androidkotlinbootcamp.di.presenterModule
import thortechasia.android.androidkotlinbootcamp.di.repositoryModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, interactorModule, repositoryModule, presenterModule))
        }

    }

}