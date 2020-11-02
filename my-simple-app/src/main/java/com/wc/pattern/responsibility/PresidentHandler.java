package com.wc.pattern.responsibility;

/**
 * 董事长审批
 * @author shovel
 * @date 2018/10/11 11:38
 * @since 1.0.0
 */
public class PresidentHandler extends Handler {

    public PresidentHandler(String name) {
        super(name);
    }

    @Override
    public void handle(PurchaseRequest request) {
        // 采购金额10000以下，董事长审批
        if (request.getAmount() < 10000) {
            System.out.println("董事长" + this.name + "审批采购单" + request.getNumber());
        } else {
            // 转发请求
            handler.handle(request);
        }
    }
}
