package yardspoon.qadeputy.launcher

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.qadeputy_activity_launcher.*
import yardspoon.qadeputy.R
import yardspoon.qadeputy.logcat.logLogs

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.qadeputy_activity_launcher)

        QADeputy_shareLogsIcon.setOnClickListener { logLogs() }
    }

}
