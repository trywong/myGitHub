package com.wc.pattern.command.calculate;

/**
 * 命令接收者
 * @author shovel
 * @date 2018/10/11 15:58
 * @since 1.0.0
 */
public class Adder {
    private int value;

    public int add(int value) {
        this.value += value;
        return this.value;
    }
}
