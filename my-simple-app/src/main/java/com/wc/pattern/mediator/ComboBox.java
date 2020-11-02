package com.wc.pattern.mediator;

/**
 * @author shovel
 * @date 2018/10/16 11:19
 * @since 1.0.0
 */
public class ComboBox extends AbstractComponent {
    public ComboBox(AbstractMediator mediator) {
        super(mediator);
    }

    @Override
    public void update() {
        System.out.println("---下拉框选择更新---");
    }
}
