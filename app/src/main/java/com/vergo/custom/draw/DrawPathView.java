package com.vergo.custom.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
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

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF1 = new RectF(200, 200, 400, 400);
        path.addArc(rectF1, -225, 225);

        RectF rectF2 = new RectF(400, 200, 600, 400);
        path.arcTo(rectF2, -180, 225);
        path.lineTo(400, 542);

        canvas.drawPath(path, paint);
    }
}
