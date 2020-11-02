package com.wc.pattern.command.calculate;

/**
 * 抽象命令类
 * @author shovel
 * @date 2018/10/11 15:52
 * @since 1.0.0
 */
public interface AbstractCommand {
    int execute(int value);

    int undo();
}
