package yardspoon.qadeputy.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import yardspoon.qadeputy.R
import yardspoon.qadeputy.logcat.logLogs
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private var intervalDisposable: Disposable = NoOpDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            logLogs()
        }
    }

    override fun onResume() {
        super.onResume()
        intervalDisposable = Observable.interval(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe {
            Timber.d("Interval $it")
        }
    }

    override fun onPause() {
        intervalDisposable.dispose()
        super.onPause()
    }
}

class NoOpDisposable : Disposable {
    override fun isDisposed() = false

    override fun dispose() {
        // Ignored
    }
}
