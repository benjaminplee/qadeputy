package yardspoon.qadeputy.logcat

import android.os.Environment
import timber.log.Timber
import java.io.File
import java.io.IOException


fun dumpLogs() {
    if (isExternalStorageWritable()) {
        getLogFile()?.let {
            run(arrayOf("logcat", "-f", it.absolutePath))
        }
    }
}

private fun run(command: Array<String>) {
    try {
        Runtime.getRuntime().exec(command).inputStream.buffered().reader().forEachLine {
            Timber.d("Exec > $it")
        }
    } catch (ioe: IOException) {
        Timber.e(ioe, "Command failed")
    }
}

private const val logFileName = "logs"

fun getLogFile(): File? {
    return File(getPublicStorageDirectory(), logFileName)
}

private const val storageDirectory = "qadeputy"

fun getPublicStorageDirectory(): File? {
    val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), storageDirectory)

    if (!file.exists() && !file.mkdirs()) {
        Timber.e("Directory, ${file.path}, not created")
    }

    return file
}

fun isExternalStorageWritable() = Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
fun isExternalStorageReadable() = Environment.getExternalStorageState() in setOf(Environment.MEDIA_MOUNTED, Environment.MEDIA_MOUNTED_READ_ONLY)
