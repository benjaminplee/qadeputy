package yardspoon.qadeputy.sample

import android.app.Application
import timber.log.Timber
import yardspoon.qadeputy.launcher.initialize

class SampleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        initialize(this)
    }
}