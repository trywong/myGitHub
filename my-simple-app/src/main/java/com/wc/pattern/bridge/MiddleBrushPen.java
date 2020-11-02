package com.wc.pattern.bridge;

/**
 * ---扩充抽象类
 * @author wangchuan
 */
public class MiddleBrushPen extends BrushPen {
    @Override
    public void paint() {
        System.out.print("中型毛笔-");
        color.paintColor();
    }
}
