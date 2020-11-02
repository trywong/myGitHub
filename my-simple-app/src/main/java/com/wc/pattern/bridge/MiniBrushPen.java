package com.wc.pattern.bridge;

/**
 * ---扩充抽象类
 * @author wangchuan
 */
public class MiniBrushPen extends BrushPen {

    @Override
    public void paint() {
        System.out.print("细毛笔-");
        color.paintColor();
    }
}
