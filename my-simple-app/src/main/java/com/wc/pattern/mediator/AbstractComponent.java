package com.wc.pattern.mediator;

/**
 * 抽象组件
 * @author shovel
 * @date 2018/10/16 11:13
 * @since 1.0.0
 */
public abstract class AbstractComponent {
    AbstractMediator mediator;

    public AbstractComponent(AbstractMediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 转发调用，联动更新其他组件
     */
    public void change() {
        mediator.componentChanged(this);
    }

    public abstract void update();
}
