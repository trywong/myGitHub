package com.wc.pattern.templeMethod;

/**
 * @author shovel
 * @date 2018/10/22 17:52
 * @since 1.0.0
 */
public abstract class AbstractEat {

    /**
     * 此方法称之为模板方法。定义实现步骤，由子类实现有差异的子步骤
     */
    public final void haveLunch() {
        this.buyFood();
        this.cook();
        this.eatFood();
        if (this.hook()) {
            this.anotherStep();
        }
    }

    private void buyFood() {
        System.out.println("买菜");
    }

    protected abstract  void cook();

    private void eatFood() {
        System.out.println("吃饭");
    }

    protected abstract void anotherStep();

    /**
     * 钩子方法，利用默认实现，定义模板方法的操作步骤。
     * 子类可以选择覆盖或不覆盖钩子方法，影响抽象类中的算法流程
     * @return
     */
    protected boolean hook() {
        return true;
    }
}
