package com.example.li.lll.advancedprogrammingli;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mGestureDetector = new GestureDetector(this);

        mGestureDetector.setOnDoubleTapListener(this);
        mGestureDetector.setIsLongpressEnabled(false);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean b = mGestureDetector.onTouchEvent(event);

        return b;
    }

    @Override
    public boolean onDown(MotionEvent e) {

        Log.d("MainActivity", "onDown");
        Log.d("MainActivity", "onDown    " + e.toString());
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.d("MainActivity", "onShowPress");
        Log.d("MainActivity", "onShowPress   " + e.toString());

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.d("MainActivity", "onSingleTapUp");
        Log.d("MainActivity", "onSingleTapUp   " + e.toString());
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

        Log.d("MainActivity", "onScroll");
        Log.d("MainActivity", "onScroll    " + e1.toString() + "===" + e2
                .toString() + " X===" + String.valueOf(distanceX) + "Y===" + String.valueOf(distanceY));
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.d("MainActivity", "onLongPress");
        Log.d("MainActivity", "onLongPress    " + e.toString());
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.d("MainActivity", "onFling");
        Log.d("MainActivity", "onFling   " + e1.toString() + "===" + e2
                .toString() + " X===" + String.valueOf(velocityX) + "Y===" + String.valueOf(velocityY));
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.d("MainActivity", "onSingleTapConfirmed");
        Log.d("MainActivity", "onSingleTapConfirmed   " + e.toString());
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {

        Log.d("MainActivity", "onDoubleTap");
        Log.d("MainActivity", "onDoubleTap   " + e.toString());
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {

        Log.d("MainActivity", "onDoubleTapEvent");
        Log.d("MainActivity", "onDoubleTapEvent   " + e.toString());
        return false;
    }
}
