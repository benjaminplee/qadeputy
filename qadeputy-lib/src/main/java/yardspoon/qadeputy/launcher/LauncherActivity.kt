package yardspoon.qadeputy.launcher

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_launcher.*
import yardspoon.qadeputy.R
import yardspoon.qadeputy.logcat.logLogs

class LauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        button.setOnClickListener {
            logLogs()
        }
    }
}
