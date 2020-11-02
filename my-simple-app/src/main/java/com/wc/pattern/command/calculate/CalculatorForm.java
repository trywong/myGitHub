package com.wc.pattern.command.calculate;

/**
 * @author shovel
 * @date 2018/10/11 16:07
 * @since 1.0.0
 */
public class CalculatorForm {
    private AbstractCommand command;

    public CalculatorForm(AbstractCommand command) {
        this.command = command;
    }

    public void setCommand(AbstractCommand command) {
        this.command = command;
    }

    public void add(int value) {
        int i = command.execute(value);
        System.out.println("计算结果：" + i);
    }

    public void undo() {
        int i = command.undo();
        System.out.println("撤销后结果：" + i);
    }
}
