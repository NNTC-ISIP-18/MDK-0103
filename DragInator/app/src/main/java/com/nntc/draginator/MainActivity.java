package com.nntc.draginator;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }

    enum State {
        fixed,
        dragging
    }

    static class MyView extends View {
        State state = State.dragging;

        Paint p;
        float x = 100;
        float y = 100;
        int side = 100;

        int springStep = 0;
        int direction = 1;

        int screenHeight;
        final double initialSpeed  = 2;
        double speed = initialSpeed;

        Timer timer = new Timer();

        float dragX = 0;
        float dragY = 0;

        public MyView(Context context) {
            super(context);
            p = new Paint();
            p.setColor(Color.GREEN);

            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (state == State.dragging) {
                        return;
                    }
                    if (y >= screenHeight - side) {
                        y = screenHeight - side;
                        // spring

                        return;
                    }
                    y += speed;
                    speed *= 1.02;
                    invalidate();
                }
            }, 100, 5);
        }

        protected void onDraw(Canvas canvas) {
            screenHeight = getHeight();
            canvas.drawRect(x, y, x + side, y + side, p);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float evX = event.getX();
            float evY = event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (evX >= x && evX <= x + side && evY >= y && evY <= y + side) {
                        state = State.dragging;
                        dragX = evX - x;
                        dragY = evY - y;
                    }
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (state == State.dragging) {
                        x = evX - dragX;
                        y = evY - dragY;
                        invalidate();
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    state = State.fixed;
                    speed = initialSpeed;
                    break;
            }
            return true;
        }
    }
}