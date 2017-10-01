package io.springboot.swapab.courseapidata.topic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TopicTest {
    private Topic topic;

    @Before
    public void setUp() throws Exception {
        topic = new Topic("topic-id", "topic-name", "topic-desc");
    }

    @Test
    public void getId() throws Exception {
        assertEquals("topic-id", topic.getId());
    }

    @Test
    public void setId() throws Exception {
        topic.setId("new-topic-id");
        assertEquals("new-topic-id", topic.getId());
    }

    @Test
    public void getName() throws Exception {
        assertEquals("topic-name", topic.getName());
    }
}