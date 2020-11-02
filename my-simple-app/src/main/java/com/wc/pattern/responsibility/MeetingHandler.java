package com.wc.pattern.responsibility;

/**
 * 董事会审批
 * @author shovel
 * @date 2018/10/11 11:38
 * @since 1.0.0
 */
public class MeetingHandler extends Handler {

    public MeetingHandler(String name) {
        super(name);
    }

    @Override
    public void handle(PurchaseRequest request) {
        System.out.println("董事会" + this.name + "审批采购单" + request.getNumber());
    }
}
