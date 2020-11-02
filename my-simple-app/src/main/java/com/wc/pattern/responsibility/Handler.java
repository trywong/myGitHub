package com.wc.pattern.responsibility;

/**
 * 抽象处理者
 * @author shovel
 * @date 2018/10/11 11:27
 * @since 1.0.0
 */
public abstract class Handler {
    protected Handler handler;  //下一个处理者
    protected String name;  //审批者姓名

    public Handler(String name) {
        this.name = name;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public abstract void handle(PurchaseRequest request);
}
