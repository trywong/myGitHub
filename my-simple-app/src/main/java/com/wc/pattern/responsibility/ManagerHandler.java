package com.wc.pattern.responsibility;

/**
 * 经理审批
 * @author shovel
 * @date 2018/10/11 11:38
 * @since 1.0.0
 */
public class ManagerHandler extends Handler {

    public ManagerHandler(String name) {
        super(name);
    }

    @Override
    public void handle(PurchaseRequest request) {
        // 采购金额5000以下，经理审批
        if (request.getAmount() < 5000) {
            System.out.println("经理" + this.name + "审批采购单" + request.getNumber());
        } else {
            // 转发请求
            handler.handle(request);
        }
    }
}
