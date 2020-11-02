package com.wc.pattern.responsibility;

/**
 * 普通员工
 * @author shovel
 * @date 2018/10/11 11:32
 * @since 1.0.0
 */
public class WorkerHandler extends Handler {

    public WorkerHandler(String name) {
        super(name);
    }

    @Override
    public void handle(PurchaseRequest request) {
        // 采购金额3000以下，普通员工审批
        if (request.getAmount() < 3000) {
            System.out.println("普通员工" + this.name + "审批采购单" + request.getNumber());
        } else {
            // 转发请求
            handler.handle(request);
        }
    }
}
