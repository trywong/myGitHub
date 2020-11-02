package com.wc.pattern.visit;

/**
 * 抽象访问者
 * @author shovel
 * @date 2018/10/23 11:27
 * @since 1.0.0
 */
public abstract class AbstractVisitor {
    public abstract void visit(Salary salary);
    public abstract void visit(Attendence attendence);
}
