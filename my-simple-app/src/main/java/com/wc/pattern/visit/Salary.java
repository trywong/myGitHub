package com.wc.pattern.visit;

/**
 * 工资
 * @author shovel
 * @date 2018/10/23 11:26
 * @since 1.0.0
 */
public class Salary extends AbstractElement {
    // 基础工资
    private int base;

    public Salary(int base, int performance) {
        this.base = base;
        this.performance = performance;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    // 绩效
    private int performance;

    @Override
    public void accept(AbstractVisitor visitor) {
        System.out.println("对工资的统计");
        visitor.visit(this);
    }

    public void increamentSalary() {
        System.out.println("加工资");
    }

    public void reduceSalary() {
        System.out.println("扣工资");
    }
}
