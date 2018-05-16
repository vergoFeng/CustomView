package com.vergo.custom.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * <p>Created by Fenghj on 2018/5/14.</p>
 */

public class DrawPieChartView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public DrawPieChartView(Context context) {
        super(context);
        init();
    }

    public DrawPieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawPieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getWidth() / 2, getHeight() / 2);

        RectF rectF = new RectF(-200, -200, 200, 200);
        mPaint.setColor(Color.RED);
        canvas.drawArc(rectF, -60, 58, true, mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectF, 0, 10, true, mPaint);
        mPaint.setColor(Color.YELLOW);
        canvas.drawArc(rectF, 12, 10, true, mPaint);
        mPaint.setColor(Color.BLACK);
        canvas.drawArc(rectF, 24, 58, true, mPaint);
        mPaint.setColor(Color.GRAY);
        canvas.drawArc(rectF, 84, 96, true, mPaint);

        RectF rectF1 = new RectF(-220, -220, 180, 180);
        mPaint.setColor(Color.GREEN);
        canvas.drawArc(rectF1, -60, -120, true, mPaint);
    }
}
