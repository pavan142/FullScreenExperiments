package com.example.fullscreenexperiments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private  View _decorView;
    private GestureDetector _tapDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _decorView = getWindow().getDecorView();
        hideSystemUI();
        setContentView(R.layout.activity_main);
        _tapDetector = new GestureDetector(this,
                new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        boolean visible = (_decorView.getSystemUiVisibility() & View.SYSTEM_UI_FLAG_HIDE_NAVIGATION) == 0;
                        if (visible)
                            hideSystemUI();
                        else
                            showSystemUI();
                        return true;
                    }
                });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        _tapDetector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    private void hideSystemUI() {
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        _decorView.setSystemUiVisibility(uiOptions);
    }

    private void showSystemUI() {
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        _decorView.setSystemUiVisibility(uiOptions);
    }

    @Override
    protected void onResume() {
        hideSystemUI();
        super.onResume();
    }
}
