package com.wc.pattern.mediator;

/**
 * @author shovel
 * @date 2018/10/16 11:18
 * @since 1.0.0
 */
public class TextLabel extends AbstractComponent {

    public TextLabel(AbstractMediator mediator) {
        super(mediator);
    }

    @Override
    public void update() {
        System.out.println("---文本显示更新---");
    }
}
