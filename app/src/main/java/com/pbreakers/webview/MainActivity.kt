package com.pbreakers.webview

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import im.delight.android.webview.AdvancedWebView
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.view.View


class MainActivity : AppCompatActivity(), AdvancedWebView.Listener {
    override fun onPageFinished(url: String?) {
        progressBar.visibility = View.GONE
    }

    override fun onPageError(errorCode: Int, description: String?, failingUrl: String?) {
        progressBar.visibility = View.GONE
        webview.loadHtml("<p>Impossible de charger la page !<p>")
    }

    override fun onDownloadRequested(url: String?, suggestedFilename: String?, mimeType: String?, contentLength: Long, contentDisposition: String?, userAgent: String?) {
    }

    override fun onExternalPageRequest(url: String?) {
    }

    override fun onPageStarted(url: String?, favicon: Bitmap?) {
        progressBar.visibility = View.VISIBLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webview.setListener(this, this)
        webview.loadUrl("http://www.bt-unique.fun", true)
    }

    override fun onResume() {
        super.onResume()
        webview.onResume()
    }

    override fun onPause() {
        super.onPause()
        webview.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        webview.onDestroy()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        webview.onActivityResult(requestCode, resultCode, intent)
    }

    override fun onBackPressed() {
        if (!webview.onBackPressed()) {
            return
        }

        super.onBackPressed()
    }
}
