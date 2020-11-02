package com.wc.pattern.build;

public abstract class ActorBuilder {
    protected Actor actor = new Actor();

    public abstract void buildType();

    public abstract void buildName();

    public abstract void buildSex();

    public abstract void buildFace();

    /**
     * 定义了建造的顺序
     * ActorBuilder.createActor()
     * @author wangchuan
     * @Date 2018年8月23日
     * @return
     */
    public Actor createActor() {
        this.buildName();
        this.buildType();
        this.buildFace();
        this.buildSex();
        return actor;
    }
}
