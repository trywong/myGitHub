package com.wc.pattern.build;

public class DevilBuilder extends ActorBuilder {

    @Override
    public void buildType() {
        actor.setType(1);
    }

    @Override
    public void buildName() {
        actor.setName("魔鬼");
    }

    @Override
    public void buildSex() {
        actor.setSex(1);
    }

    @Override
    public void buildFace() {
        actor.setFace("魔鬼的脸");
    }
}
