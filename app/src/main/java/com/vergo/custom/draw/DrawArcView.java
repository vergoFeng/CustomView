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

public class DrawArcView extends View {

    public DrawArcView(Context context) {
        super(context);
    }

    public DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF(200, 200, 800, 500);
//        canvas.drawOval(rectF, mPaint);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawArc(200, 200, 800, 500, -110, 100, true, mPaint); // 绘制扇形
            canvas.drawArc(200, 200, 800, 500, 20, 140, false, mPaint); // 绘制弧形
//            paint.setStyle(Paint.Style.STROKE); // 画线模式
//            canvas.drawArc(200, 200, 800, 500, 180, 60, false, mPaint); // 绘制不封口的弧形
        } else {
            canvas.drawArc(rectF, -110, 100, true, mPaint);
            canvas.drawArc(rectF, 20, 140, false, mPaint);
        }
    }
}
