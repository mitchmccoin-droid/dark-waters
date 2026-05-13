package com.darkwaters.sentinel;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
public class MainActivity extends Activity {
    private WebView webView;
    @SuppressLint({"SetJavaScriptEnabled","WebViewApiAvailability"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN|WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_FULLSCREEN|WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        webView = new WebView(this);
        setContentView(webView);
        webView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_FULLSCREEN|
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE|
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|
            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        WebSettings s = webView.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setAllowFileAccess(true);
        s.setAllowContentAccess(true);
        s.setAllowFileAccessFromFileURLs(true);
        s.setAllowUniversalAccessFromFileURLs(true);
        s.setMediaPlaybackRequiresUserGesture(false);
        s.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.loadUrl("file:///android_asset/index.html");
    }
    @Override public void onBackPressed() { if (webView.canGoBack()) webView.goBack(); }
}
