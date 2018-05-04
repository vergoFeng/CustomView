---
layout: post
title: "自定义View之绘制1-2"
date: 2018-05-06
toc: false
tags:
	- View
---

## drawPath 绘制自定义图形

上一篇说过，drawPath(path) 这个方法是通过描述路径的方式来绘制图形的，它的 path 参数就是用来描述图形路径的对象。

Path 可以描述直线、二次曲线、三次曲线、圆、椭圆、弧形、矩形、圆角矩形。把这些图形结合起来，就可以描述出很多复杂的图形。下面我就说一下具体的怎么把这些图形描述出来。

Path 有两类方法，一类是直接描述路径的，另一类是辅助的设置或计算。

<!-- more -->

## Path 方法第一类：直接描述路径。

这一类方法还可以细分为两组：添加子图形和画线（直线或曲线）

### 第一组： addXxx() ——添加子图形

### 添加圆<br>addCircle(float x, float y, float radius, Direction dir) 