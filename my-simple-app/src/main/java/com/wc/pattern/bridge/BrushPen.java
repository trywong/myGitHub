package com.wc.pattern.bridge;

/**
 * 毛笔---抽象类
 * @author wangchuan
 */
public abstract class BrushPen {
    // 将颜色设置进来，供子类实现paint时使用
    protected Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void paint();
}
