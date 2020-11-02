package com.wc.pattern.mediator;

/**
 * @author shovel
 * @date 2018/10/16 11:21
 * @since 1.0.0
 */
public class ConcreteMediator implements AbstractMediator {
    Button button;
    TextLabel label;
    ComboBox comboBox;

    @Override
    public void componentChanged(AbstractComponent component) {
        if (component == button) {
            button.update();
            comboBox.update();
        } else if (component == label) {
            label.update();
        } else if (component == comboBox) {
            comboBox.update();
            label.update();
        }
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public TextLabel getLabel() {
        return label;
    }

    public void setLabel(TextLabel label) {
        this.label = label;
    }

    public ComboBox getComboBox() {
        return comboBox;
    }

    public void setComboBox(ComboBox comboBox) {
        this.comboBox = comboBox;
    }
}
