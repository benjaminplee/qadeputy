package yardspoon.qadeputy.launcher

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.qadeputy_activity_launcher.*
import yardspoon.qadeputy.R
import yardspoon.qadeputy.logcat.dumpLogs

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.qadeputy_activity_launcher)

        QADeputy_infoIcon.setOnClickListener { Toast.makeText(this, "Launch App Info", Toast.LENGTH_SHORT).show() }
        QADeputy_crashIcon.setOnClickListener { Toast.makeText(this, "Launch Test Crash", Toast.LENGTH_SHORT).show() }
        QADeputy_logsIcon.setOnClickListener {
            dumpLogs()
            Toast.makeText(this, "Launch Log Share", Toast.LENGTH_SHORT).show()
        }
        QADeputy_captureIcon.setOnClickListener { Toast.makeText(this, "Launch Screenshot Capture", Toast.LENGTH_SHORT).show() }
    }

}
