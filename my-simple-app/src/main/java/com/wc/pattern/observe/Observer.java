package com.wc.pattern.observe;

/**
 * @author shovel
 * @date 2018/10/17 14:07
 * @since 1.0.0
 */
public abstract class Observer {

    public abstract String getName();

    public abstract void setName(String name);

    /**
     * 遭受攻击
     */
    public abstract void beAttacked(AbstractController allyController);

    /**
     * 支援队友
     */
    public abstract void help();
}
