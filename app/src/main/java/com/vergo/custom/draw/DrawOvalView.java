package com.vergo.custom.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * <p>Created by Fenghj on 2017/10/21.</p>
 */

public class DrawOvalView extends View {

    public DrawOvalView(Context context) {
        super(context);
    }

    public DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        RectF rectF = new RectF(100,100,800,400);
//        canvas.drawOval(rectF, mPaint);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawOval(100, 100, 800, 400, mPaint);
        }
    }
}
