package com.vergo.custom.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * <p>Created by Fenghj on 2018/5/4.</p>
 */

public class DrawPathView extends View {
    public DrawPathView(Context context) {
        super(context);
    }

    public DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint paint = new Paint();
    Path path = new Path();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);

        //绘制爱心
//        RectF rectF1 = new RectF(200, 200, 400, 400);
//        path.addArc(rectF1, -225, 225);
//        RectF rectF2 = new RectF(400, 200, 600, 400);
//        path.arcTo(rectF2, -180, 225, true);
//        path.lineTo(400, 542);
//        path.close();

        //绘制圆形
//        path.addCircle(300, 300, 200, Path.Direction.CW);

        //moveTo()
//        path.lineTo(200, 200); // 由当前位置 (0, 0) 向 (100, 100) 画一条直线
//        path.moveTo(300, 200);
//        path.lineTo(300, 0); // 由当前位置 (100, 100) 向正右方 100 像素的位置画一条直线

        //arcTo()
//        path.lineTo(200, 200);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            path.arcTo(200, 200, 600, 600, -90, 90, true);
////            path.arcTo(200, 200, 600, 600, -90, 90, false);
//        }

        //close()
        path.moveTo(100, 100);
        path.lineTo(500, 100);
        path.lineTo(300, 300);
        path.close();

        canvas.drawPath(path, paint);
    }
}
