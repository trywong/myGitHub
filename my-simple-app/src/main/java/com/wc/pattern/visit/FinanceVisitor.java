package com.wc.pattern.visit;

/**
 * @author shovel
 * @date 2018/10/23 14:06
 * @since 1.0.0
 */
public class FinanceVisitor extends AbstractVisitor {
    @Override
    public void visit(Salary salary) {

    }

    @Override
    public void visit(Attendence attendence) {
        System.out.println("出勤天数：" + attendence.getDays());
        if (attendence.getDays() > 22) {
            attendence.transfer();
        }
    }
}
