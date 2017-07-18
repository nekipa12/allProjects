package com.example.browser;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class MyBrowserActivity extends Activity {
	private WebView wv1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_browser);
		wv1 = (WebView) findViewById(R.id.wv1);
		Uri uri = getIntent().getData();
		wv1.loadUrl(uri.toString());//открывает браузер
		
	}
}
