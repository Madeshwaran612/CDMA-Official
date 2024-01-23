package com.madesh.CDMA_Official.Clubs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.madesh.CDMA_Official.Utility.Common;
import com.madesh.CDMA_Official.R;

public class RpfAyanavaram extends AppCompatActivity {
    WebView webView;
    NetworkChangeListener networkChangeListener = new NetworkChangeListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rpf_ayanavaram);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        webView = findViewById(R.id.ayaweb);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://rpf-ayanavaram.blogspot.com/");
        webView.setWebViewClient(new networkControler());
        if (networkInfo == null || !networkInfo.isAvailable() || !networkInfo.isConnected()) {

            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.alert);
            dialog.setCancelable(false);
            dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
            dialog.getWindow().getAttributes().windowAnimations = android.R.style.TextAppearance_Holo_WindowTitle;
            dialog.show();
            Button button = dialog.findViewById(R.id.retry);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recreate();
                }
            });
            dialog.show();
        }

    }

    public class networkControler extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            return true;
        }

    }

    @Override
    public void onStart() {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeListener, filter);
        super.onStart();
    }

    @Override
    protected void onStop() {


        unregisterReceiver(networkChangeListener);
        super.onStop();
    }

    public class NetworkChangeListener extends BroadcastReceiver {

        Button button7;

        @Override
        public void onReceive(Context context, Intent intent) {
            if (!Common.isConnectedToInternet(context)) {

                Dialog dialog = new Dialog(RpfAyanavaram.this);
                dialog.setContentView(R.layout.alert);
                dialog.setCancelable(false);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                dialog.getWindow().getAttributes().windowAnimations = android.R.style.TextAppearance_Holo_WindowTitle;
                dialog.show();
                Button button = dialog.findViewById(R.id.retry);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        recreate();
                    }
                });
                dialog.show();
            }

        }
    } @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();

        }else {
            super.onBackPressed();
        }
    }
}