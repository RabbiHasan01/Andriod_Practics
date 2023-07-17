package com.example.gsapandsass03;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;

import com.example.gsapandsass03.NextActivity;
import com.example.gsapandsass03.R;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true); // Enable JavaScript (optional)

        // Load an HTML file from the assets folder
        webView.loadUrl("file:///android_asset/gsap.html");

        // Create a handler
        Handler handler = new Handler();

        // Define a delay of 5 seconds (5000 milliseconds)
        int delay = 5000;

        // Define the action to be performed after the delay
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // Start the next activity or perform any desired action
                Intent nextActivityIntent = new Intent(MainActivity.this, NextActivity.class);
                startActivity(nextActivityIntent);
                finish(); // Optional: Close the current activity if needed
            }
        };

        // Post the runnable to be executed after the delay
        handler.postDelayed(runnable, delay);
    }
}
