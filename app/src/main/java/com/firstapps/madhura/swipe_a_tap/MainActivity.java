package com.firstapps.madhura.swipe_a_tap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;
import android.view.MotionEvent;




public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener {

    private TextView maddysText;
    private Button maddysButton;
    private GestureDetectorCompat gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maddysButton = (Button)findViewById(R.id.maddysButton);
        maddysText = (TextView)findViewById(R.id.maddysText);
        this.gestureDetector = new GestureDetectorCompat(this,this);
        gestureDetector.setOnDoubleTapListener(this);

        maddysButton.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        maddysText.setText("HUh..you clicked me dumbass -_- !");
                    }
                }
        );
    }


    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        maddysText.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        maddysText.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        maddysText.setText("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        maddysText.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        maddysText.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        maddysText.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        maddysText.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        maddysText.setText("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float v, float v1) {
        float diffX = e2.getX() - e1.getX();
        float diffY = e2.getY() - e1.getY();


        if(Math.abs(diffX) > Math.abs(diffY)) {
            if(diffX > 0){
                maddysText.setText("Swiped RIGHT");
            }
            else{
                maddysText.setText("Swiped LEFT");
            }

        }
        else{
            if(diffY > 0){
                maddysText.setText("Swiped DOWN");
            }
            else{
                maddysText.setText("Swiped UP");
            }

        }
/*
        if(e1.getY()<e2.getY()) {
            maddysText.setText("Swiped DOWN");
        }
        if(e1.getY()>e2.getY()) {
            maddysText.setText("Swiped UP");
        }
*/
        return true;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }



}
