package io.springboot.swapab.courseapidata.blueprints;

import com.tobedevoured.modelcitizen.ModelFactory;
import com.tobedevoured.modelcitizen.annotation.Blueprint;
import com.tobedevoured.modelcitizen.annotation.Default;
import io.springboot.swapab.courseapidata.topic.Topic;

@Blueprint(Topic.class)
public class TopicBlueprint {
    @Default
    String id = "spring-boot";

    @Default
    String name = "Spring boot is an MVC framework";

    @Default
    String description = "Spring boot brings in Convention over configuration";

    ModelFactory modelFactory = new ModelFactory();
    // modelFactory.registerBlueprint(Topic.class);
}
