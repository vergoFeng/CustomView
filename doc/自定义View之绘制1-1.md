# 自定义View之绘制1-1
自定义绘制的方法是重写绘制方法，最常用的是onDraw()，绘制的关键是Canvas的使用。

## 自定义绘制知识的4个级别
* Canvas 的 drawXXX() 系列方法
* Paint 的完全攻略
* Canvas 对绘制的辅助——范围裁切和几何变换。
* 可以使用不同的绘制方法来控制遮盖关系。

## Canvas.drawXXX()系列方法
### 绘制颜色<br>drawColor(int color)
```
canvas.drawColor(Color.Yellow);
```
![](https://i.imgur.com/HKXY84s.png)

类似的方法还有 drawRGB(int r, int g, int b) 和 drawARGB(int a, int r, int g, int b) ，它们和  drawColor(color) 只是使用方式不同，作用都是一样的。
```
canvas.drawRGB(100, 200, 100);  
canvas.drawARGB(100, 100, 200, 100); 
```
这类颜色填充方法一般用于在绘制之前设置底色，或者在绘制之后为界面设置半透明蒙版。

### 绘制圆形<br>drawCircle(float centerX, float centerY, float radius, Paint paint)
前两个参数 centerX centerY 是圆心的坐标，第三个参数 radius 是圆的半径，单位都是像素
```
canvas.drawCircle(250, 250, 200, mPaint);
```
![](https://i.imgur.com/8K5t0Tz.png)

### 绘制矩形<br>drawRect(float left, float top, float right, float bottom, Paint paint) 
确定确定一个矩形最少需要四个数据，就是对角线的两个点的坐标值，这里一般采用左上角和右下角的两个点的坐标。
```
canvas.drawRect(100, 100, 800, 400, mPaint);
canvas.drawRect(100, 500, 500, 900, mPaint);
```
![](https://i.imgur.com/UnQJLqQ.png)

另外，它还有两个重载方法 drawRect(Rect rect, Paint paint) 和 drawRect(RectF rectf, Paint paint)，让你可以直接填写 RectF 或 Rect 对象来绘制矩形。
```
Rect rect = new Rect(100,100,800,400);
canvas.drawRect(rect, mPaint);

RectF rectF = new RectF(100,100,800,400);
canvas.drawRect(rectF, mPaint);
```
ps：Rect，RectF两者最大的区别就是精度不同，Rect是int(整形)的，而RectF是float(单精度浮点型)的

### 绘制点<br>drawPoint(float x, float y, Paint paint)
x 和 y 是点的坐标
```
mPaint.setStrokeWidth(20);
canvas.drawPoint(200, 200, mPaint);
```
![](https://i.imgur.com/GPszSPw.png)

### 绘制一组点<br>drawPoints(float[] pts, int offset, int count, Paint paint) <br> drawPoints(float[] pts, Paint paint)
pts 这个数组是点的坐标，每两个成一对；offset 表示跳过数组的前几个数再开始记坐标；count 表示一共要绘制几个点。
```
mPaint.setStrokeWidth(20);

float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};
/*
 * 跳过两个数，即前两个 0
 * 一共绘制 8 个数（4 个点）
 * 即绘制四个点：(50, 50) (50, 100) (100, 50) (100, 100)
 */
canvas.drawPoints(points, 2, 8, mPaint);

//绘制三个点
canvas.drawPoints(new float[]{
        200, 200,
        300, 200,
        400, 200
}, mPaint);
```
![](https://i.imgur.com/oIkg4xG.png)

### 绘制椭圆<br>drawOval(float left, float top, float right, float bottom, Paint paint)
绘制椭圆实际上就是绘制一个矩形的内切图形，所以参数和绘制矩形参数一致。
另外，它还有一个重载方法 drawOval(RectF rect, Paint paint)，让你可以直接填写 RectF 来绘制椭圆。
```
canvas.drawRect(100, 100, 800, 400, mPaint);

RectF rectF = new RectF(100,100,800,400);
canvas.drawOval(rectF, mPaint);
```
![](https://i.imgur.com/6fo90HS.png)

注意：drawOval(float left, float top, float right, float bottom, Paint paint)方法是在api21的时候增加的，所以使用的时候需要注意minSdkVersion的值，使用该方法的时候要判断版本，或者直接使用drawOval(RectF rect, Paint paint)方法。

### 绘制直线<br>drawLine(float startX, float startY, float stopX, float stopY, Paint paint)
startX, startY, stopX, stopY 分别是线的起点和终点坐标。
```
mPaint.setStrokeWidth(10);
canvas.drawLine(200, 200, 800, 500, mPaint);
```
![](https://i.imgur.com/rxut3OS.png)

### 绘制一组直线<br>drawLines(float[] pts, int offset, int count, Paint paint) <br> drawLines(float[] pts, Paint paint)
参数的含义和绘制点的参数含义一样，可参考绘制点。
```
float[] points = {200, 200, 200, 800, 200, 500, 500, 500, 500, 200, 500, 800};
canvas.drawLines(points, mPaint);
```
![](https://i.imgur.com/Q6zgvcW.png)

### 绘制圆角矩形<br>drawRoundRect(float left, float top, float right, float bottom, float rx, float ry, Paint paint)<br>drawRoundRect(RectF rect, float rx, float ry, Paint paint)
left, top, right, bottom 是左上角和右下角的两个点的坐标, rx 和 ry 是圆角的横向半径和纵向半径。
```
//api>=21
canvas.drawRoundRect(100, 100, 700, 400, 50, 50, mPaint);

RectF rectF = new RectF(100, 100, 700, 400);
canvas.drawRoundRect(rectF, 50, 50, mPaint);
```
![](https://i.imgur.com/Sro7zxo.png)

和绘制椭圆一样，第一个drawRoundRect方法是在api21的时候增加的，所以使用的时候需要注意minSdkVersion的值，使用该方法的时候要判断版本，或者直接使用第二个drawRoundRect方法。

有一点值得注意的就是，这里的圆角实际上不是一个正圆的圆弧，而是椭圆的圆弧，rx 和 ry两个参数实际上是椭圆的两个半径，所以当rx为宽度的一半，ry为高度的一半时，就会发现绘制出来的刚好是一个椭圆
```
RectF rectF = new RectF(100, 100, 700, 400);
canvas.drawRoundRect(rectF, 300, 150, mPaint);
```
![](https://i.imgur.com/MwOu676.png)

所以在当rx大于宽度的一半，ry大于高度的一半时，实际上是无法计算出圆弧的，所以drawRoundRect对大于该数值的参数进行了限制(修正)，凡是大于一半的参数均按照一半来处理，即绘制出来的均是椭圆。

### 绘制弧形或扇形<br>drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, Paint paint)<br>drawArc(RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint)
drawArc() 是使用一个椭圆来描述弧形的。
left, top, right, bottom 描述的是这个弧形所在的椭圆；
startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度）；
sweepAngle 是弧形划过的角度；
useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形。
```
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
    canvas.drawArc(200, 200, 800, 500, -110, 100, true, mPaint); // 绘制扇形
    canvas.drawArc(200, 200, 800, 500, 20, 140, false, mPaint); // 绘制弧形
} else {
    RectF rectF = new RectF(200, 200, 800, 500);
    canvas.drawArc(rectF, -110, 100, true, mPaint);
    canvas.drawArc(rectF, 20, 140, false, mPaint);
}
```
![](https://i.imgur.com/HXP6T87.png)

