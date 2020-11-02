package com.wc.pattern.visit;

/**
 * @author shovel
 * @date 2018/10/23 11:42
 * @since 1.0.0
 */
public class HumanResourceVisitor extends AbstractVisitor {
    @Override
    public void visit(Salary salary) {
        /**
         * 人力资源根据员工工资，进行一些业务逻辑
         */

        System.out.println("绩效工资:" + salary.getPerformance());
        // 还可以调用元素类的其他业务方法
        if (salary.getPerformance() > 100) {
            salary.increamentSalary();
        }
    }

    @Override
    public void visit(Attendence attendence) {

    }
}
