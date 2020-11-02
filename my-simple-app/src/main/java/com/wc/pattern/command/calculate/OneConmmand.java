package com.wc.pattern.command.calculate;

/**
 * 具体命令类
 * @author shovel
 * @date 2018/10/11 15:55
 * @since 1.0.0
 */
public class OneConmmand implements AbstractCommand {
    private Adder adder = new Adder();
    private int value;

    @Override
    public int execute(int value) {
        this.value = value;
        return adder.add(value);
    }

    @Override
    public int undo() {
        return adder.add(-value);
    }
}
