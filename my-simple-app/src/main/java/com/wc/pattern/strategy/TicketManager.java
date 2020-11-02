package com.wc.pattern.strategy;

/**
 * @author shovel
 * @date 2018/10/22 17:19
 * @since 1.0.0
 */
public class TicketManager {
    private AbstractStrategy strategy;

    private String filmName;
    private float price;

    public AbstractStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(AbstractStrategy strategy) {
        this.strategy = strategy;
    }

    public TicketManager(String filmName, float price) {
        this.filmName = filmName;
        this.price = price;
    }

    public void sellTicket() {
        strategy.sell(filmName, price);
    }
}
