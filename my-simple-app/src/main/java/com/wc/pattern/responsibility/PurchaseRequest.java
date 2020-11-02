package com.wc.pattern.responsibility;

/**
 * 采购
 * @author shovel
 * @date 2018/10/11 11:23
 * @since 1.0.0
 */
public class PurchaseRequest {
    private int amount; //采购金额
    private String number;  //采购单编号

    public PurchaseRequest(int amount, String number) {
        this.amount = amount;
        this.number = number;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
