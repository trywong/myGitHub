package com.wc.pattern.mediator;

/**
 * @author shovel
 * @date 2018/10/16 11:17
 * @since 1.0.0
 */
public class Button extends AbstractComponent {

    public Button(AbstractMediator mediator) {
        super(mediator);
    }

    @Override
    public void update() {
        System.out.println("---按钮状态更新----");
    }
}
