package com.vergo.custom.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * <p>Created by Fenghj on 2017/10/21.</p>
 */

public class DrawRoundRectView extends View {

    public DrawRoundRectView(Context context) {
        super(context);
    }

    public DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        RectF rectF = new RectF(100, 100, 700, 400);
//        canvas.drawRoundRect(rectF, 300, 150, mPaint);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawRoundRect(100, 100, 700, 400, 50, 50, mPaint);
        } else {
            RectF rectF = new RectF(100, 100, 700, 400);
            canvas.drawRoundRect(rectF, 50, 50, mPaint);
        }
    }
}
