package com.wc.pattern.mediator;

/**
 * 抽象中介者
 * @author shovel
 * @date 2018/10/16 11:02
 * @since 1.0.0
 */
public interface AbstractMediator {

    /**
     * 组件更新后的操作
     */
    public void componentChanged(AbstractComponent component);
}
