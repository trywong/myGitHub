package com.wc.pattern.build;

public class HeroBuilder extends ActorBuilder {

    @Override
    public void buildType() {
        actor.setType(0);
    }

    @Override
    public void buildName() {
        actor.setName("英雄");
    }

    @Override
    public void buildSex() {
        actor.setSex(1);
    }

    @Override
    public void buildFace() {
        actor.setFace("英雄的脸");
    }
}
