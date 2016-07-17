package io.github.xudaojie.androiddemo.webview;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import io.github.xudaojie.androiddemo.BaseActivity;
import io.github.xudaojie.androiddemo.R;

/**
 * Created by xdj on 15/11/3.
 */
public class WebViewActivity extends BaseActivity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_activity);
        mWebView = (WebView) findViewById(R.id.web_view);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("file:///android_asset/webview.html");
    }

    public void callJsOnClick(View view) {
        mWebView.loadUrl("javascript:test('王小三')");
    }
}
