package com.wc.pattern.build;

public class ActorController {
    ActorBuilder builder;

    public Actor actorConstruct(ActorBuilder builder) {
        /*builder.buildType();
        builder.buildSex();
        builder.buildName();
        builder.buildFace();*/

        return builder.createActor();
    }
}
