package com.vergo.custom.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * <p>Created by Fenghj on 2017/10/21.</p>
 */

public class DrawLineView extends View {

    public DrawLineView(Context context) {
        super(context);
    }

    public DrawLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStrokeWidth(10);
//        canvas.drawLine(200, 200, 800, 500, mPaint);
        float[] points = {200, 200, 200, 800, 200, 500, 500, 500, 500, 200, 500, 800};
        canvas.drawLines(points, mPaint);
    }
}
