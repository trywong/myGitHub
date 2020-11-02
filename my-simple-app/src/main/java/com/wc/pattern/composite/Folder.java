package com.wc.pattern.composite;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Component {
    private List<Component> list;

    public Folder(String name) {
        this.name = name;
        list = new ArrayList<>();
    }

    @Override
    public void add(Component component) {
        list.add(component);
    }

    @Override
    public void remove(Component component) {
        list.remove(component);
    }

    @Override
    public void display() {
        System.out.println("文件夹:" + name);
        // 递归处理
        for (Component component : list) {
            component.display();
        }
    }
}
