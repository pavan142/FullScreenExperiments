package com.example.fullscreenexperiments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private  View _decorView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _decorView = getWindow().getDecorView();
        hideSystemUI();
        setContentView(R.layout.activity_main);
    }

    private void hideSystemUI() {
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        _decorView.setSystemUiVisibility(uiOptions);
    }

    @Override
    protected void onResume() {
        hideSystemUI();
        super.onResume();
    }
}
