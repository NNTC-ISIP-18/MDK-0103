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

    static class MyView extends View {
        Paint p;
        // координаты для рисования квадрата
        float x = 100;
        float y = 100;
        int side = 100;

        int screenHeight;
        int speed = 3;

        Timer timer = new Timer();

        // переменные для перетаскивания
        boolean drag = false;
        float dragX = 0;
        float dragY = 0;

        public MyView(Context context) {
            super(context);
            p = new Paint();
            p.setColor(Color.GREEN);

            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (y > screenHeight - side) {
                        y = screenHeight - side;
                    }
                    y += speed;
                    speed *= 1.1;
                    invalidate();
                }
            }, 100, 5);
        }

        protected void onDraw(Canvas canvas) {
            screenHeight = getHeight();
            // рисуем квадрат
            canvas.drawRect(x, y, x + side, y + side, p);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            // координаты Touch-события
            float evX = event.getX();
            float evY = event.getY();

            switch (event.getAction()) {
                // касание началось
                case MotionEvent.ACTION_DOWN:
                    // если касание было начато в пределах квадрата
                    if (evX >= x && evX <= x + side && evY >= y && evY <= y + side) {
                        // включаем режим перетаскивания
                        drag = true;
                        // разница между левым верхним углом квадрата и точкой касания
                        dragX = evX - x;
                        dragY = evY - y;
                    }
                    break;
                // тащим
                case MotionEvent.ACTION_MOVE:
                    // если режим перетаскивания включен
                    if (drag) {
                        // определеяем новые координаты для рисования
                        x = evX - dragX;
                        y = evY - dragY;
                        // перерисовываем экран
                        invalidate();
                    }
                    break;
                // касание завершено
                case MotionEvent.ACTION_UP:
                    // выключаем режим перетаскивания
                    drag = false;
                    break;
            }
            return true;
        }
    }
}