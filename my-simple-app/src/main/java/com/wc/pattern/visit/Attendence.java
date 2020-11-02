package com.wc.pattern.visit;

/**
 * @author shovel
 * @date 2018/10/23 11:41
 * @since 1.0.0
 */
public class Attendence extends AbstractElement {
    private int days;

    public Attendence(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public void accept(AbstractVisitor visitor) {
        System.out.println("对考勤的统计");
        visitor.visit(this);
    }

    public void transfer() {
        System.out.println("结转加班天数");
    }
}
