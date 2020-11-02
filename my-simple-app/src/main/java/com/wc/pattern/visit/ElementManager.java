package com.wc.pattern.visit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shovel
 * @date 2018/10/23 14:11
 * @since 1.0.0
 */
public class ElementManager {
    private List<AbstractElement> elements = new ArrayList<>();

    public void accept(AbstractVisitor visitor) {
        for (AbstractElement element : elements) {
            element.accept(visitor);
        }
    }

    public void addElement(AbstractElement element) {
        elements.add(element);
    }

    public void removeElement(AbstractElement element) {
        elements.remove(element);
    }
}
