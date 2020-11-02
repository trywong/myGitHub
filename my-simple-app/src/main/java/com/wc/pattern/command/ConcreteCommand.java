package com.wc.pattern.command;

/**
 * 具体命令类
 * @author shovel
 * @date 2018/10/11 14:52
 * @since 1.0.0
 */
public class ConcreteCommand implements Command {
    private Reciever reciever;

    @Override
    public void execute() {
        reciever.action();
    }
}
