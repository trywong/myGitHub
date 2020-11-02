package com.wc.pattern.composite;

public class File extends Component {

    public File(String name) {
        this.name = name;
    }

    @Override
    public void add(Component component) {
        throw new NullPointerException("should not be here");
    }

    @Override
    public void remove(Component component) {
        throw new NullPointerException("should not be here");
    }

    @Override
    public void display() {
        System.out.println("文件：" + name);
    }
}
