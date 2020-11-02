package com.wc.pattern.build;

public class AngelBuilder extends ActorBuilder {

    @Override
    public void buildType() {
        actor.setType(2);
    }

    @Override
    public void buildName() {
        actor.setName("天使");
    }

    @Override
    public void buildSex() {
        actor.setSex(0);
    }

    @Override
    public void buildFace() {
        actor.setFace("天使般的脸");
    }
}
