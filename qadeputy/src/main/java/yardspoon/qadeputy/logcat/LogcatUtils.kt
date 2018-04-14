package yardspoon.qadeputy.logcat

import timber.log.Timber
import java.io.IOException


fun logLogs() {
    try {
        val command = arrayOf("logcat", "-t", "10")
        Runtime.getRuntime().exec(command).inputStream.buffered().reader().forEachLine {
            Timber.i(it)
        }
    } catch (ioe: IOException) {
        Timber.e(ioe, "getAppLogs failed")
    }
}
