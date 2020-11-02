package com.wc.pattern.command;

/**
 * 请求调用者
 * @author shovel
 * @date 2018/10/11 14:54
 * @since 1.0.0
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void invoke() {
        command.execute();
    }
}
