package com.wc.pattern.decorator;

/**
 * <pre>
 *
 * </pre>
 *
 * @author wangchuan
 * @date 2018/9/11 15:07
 * @since 1.0.0
 */
public class ChildComponent implements Component {

    @Override
    public void operation() {
        System.out.println("子组件operation方法");
    }
}
