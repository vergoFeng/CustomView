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

public class DrawPointView extends View {

    public DrawPointView(Context context) {
        super(context);
    }

    public DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStrokeWidth(20);
//        canvas.drawPoint(200, 200, mPaint);

        canvas.drawPoints(new float[]{
                200, 200,
                300, 200,
                400, 200
        }, mPaint);

        float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};
        /*
         * 跳过两个数，即前两个 0
         * 一共绘制 8 个数（4 个点）
         * 绘制四个点：(50, 50) (50, 100) (100, 50) (100, 100)
         */
        canvas.drawPoints(points, 2, 8, mPaint);
    }
}
