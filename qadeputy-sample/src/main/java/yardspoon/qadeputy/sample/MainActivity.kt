package yardspoon.qadeputy.sample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private var intervalDisposable: Disposable = NoOpDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainText.setOnClickListener {
            startActivity(Intent(this, yardspoon.qadeputy.launcher.LauncherActivity::class.java))
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
