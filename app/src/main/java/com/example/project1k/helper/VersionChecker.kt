package com.example.project1k.helper

import android.os.AsyncTask
import android.util.Log
import org.jsoup.Jsoup

// this class is used for get app version name from play market
open class VersionChecker : AsyncTask<String?, String?, String?>() {

    private var newVersion: String? = null
    private val TAG = VersionChecker::class.java.simpleName.toString()

    override fun doInBackground(vararg p0: String?): String? {
        try {
            newVersion =
                Jsoup.connect("https://play.google.com/store/apps/details?id=net.giosis.shopping.sg&hl=en&gl=US")
                    .timeout(1000)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.google.com")
                    .get()
                    .select("div.hAyfc:nth-child(4) > span:nth-child(2) > div:nth-child(1) > span:nth-child(1)")
                    .first()
                    .ownText()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        Log.d(TAG, "doInBackground: $newVersion")
        return newVersion
    }
}
