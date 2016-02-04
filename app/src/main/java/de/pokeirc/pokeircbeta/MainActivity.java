package de.pokeirc.pokeircbeta;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;


@SuppressLint("CutPasteId") public class MainActivity extends Activity {

    @SuppressLint("SetJavaScriptEnabled") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView engine = (WebView) findViewById(R.id.web_engine);


        WebView webView = (WebView) findViewById(R.id.web_engine);
               webView.getSettings().setJavaScriptEnabled(true);
               webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
               webView.setWebViewClient(new WebViewClient());

        engine.loadUrl("https://pokeirc.de/board/");

    }
    public void homepage(View v) {
    	WebView webView = (WebView) findViewById(R.id.web_engine);
        webView.loadUrl("https://pokeirc.de/board/");
    }
    public void backsite(View v) {
    	WebView webView = (WebView) findViewById(R.id.web_engine);
        webView.goBack();
    }
    public void vor(View v) {
    	WebView webView = (WebView) findViewById(R.id.web_engine);
        webView.goForward();
    }
    public void refresh(View v) {
    	WebView webView = (WebView) findViewById(R.id.web_engine);
        webView.reload();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            //return true;
            WebView webView = (WebView) findViewById(R.id.web_engine);
            webView.reload();
        }
        else if (id == R.id.home) {
        //return true;
        WebView webView = (WebView) findViewById(R.id.web_engine);
        webView.loadUrl("https://pokeirc.de/board/");
        return true;
    }
        else if (id == R.id.next) {
        //return true;
        WebView webView = (WebView) findViewById(R.id.web_engine);
        webView.goForward();
        return true;
    }
        else if (id == R.id.back) {
        //return true;
        WebView webView = (WebView) findViewById(R.id.web_engine);
        webView.goBack();
        return true;
    }
		return false;
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	WebView webView = (WebView) findViewById(R.id.web_engine);
    	if(event.getAction() == KeyEvent.ACTION_DOWN) {
    		switch(keyCode) {
            	case KeyEvent.KEYCODE_BACK:
            		if(webView.canGoBack()) {
            			webView.goBack();
            		} else {
            			finish();
            		}
            		return true;
    		}
    }
    return super.onKeyDown(keyCode, event);
}
}
