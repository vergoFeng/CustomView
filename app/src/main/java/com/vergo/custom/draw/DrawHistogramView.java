package com.vergo.custom.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/**
 * <p>Created by Fenghj on 2018/5/14.</p>
 */

public class DrawHistogramView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int originX;
    private int originY;
    private int space;
    private int rectWidth;
    private float[] heightPercent = {0.3f, 0.8f, 0.5f, 0.4f, 0.9f};

    public DrawHistogramView(Context context) {
        super(context);
        init();
    }

    public DrawHistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawHistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        originX = dp2px(20);
        space = dp2px(12);
        rectWidth = dp2px(50);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        originY = getHeight() / 3 + 100;

        //绘制坐标系
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(dp2px(1));
        mPaint.setColor(Color.BLACK);
        canvas.drawLine(originX, originY, originX, originX, mPaint);
        canvas.drawLine(originX, originY, getWidth() - originX, originY, mPaint);

        //绘制直方图
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLUE);
        mPaint.setTextSize(sp2px(12));
        int rectLeft = originX + space;
        for (int i = 0; i < 5; i++) {
            canvas.drawRect(rectLeft, originY - (originY * heightPercent[i]), rectLeft + rectWidth, originY, mPaint);
            //绘制文字
            canvas.drawText("android", rectLeft + (rectWidth - getTextRect("android", mPaint).width()) / 2, originY + dp2px(12), mPaint);
            rectLeft += rectWidth + space;
        }

    }

    private Rect getTextRect(String text, Paint paint) {
        Rect rect = new Rect();
        paint.getTextBounds(text, 0, text.length(), rect);
        return rect;
    }

    public int dp2px(float dpValue) {
        float scale = getResources().getDisplayMetrics().density;
        return (int)(dpValue * scale + 0.5F);
    }


    public int sp2px(float spValue) {
        float fontScale = getResources().getDisplayMetrics().scaledDensity;
        return (int)(spValue * fontScale + 0.5F);
    }
}
