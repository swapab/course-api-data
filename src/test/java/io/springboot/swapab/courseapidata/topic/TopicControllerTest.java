package io.springboot.swapab.courseapidata.topic;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TopicController.class, secure = false)
public class TopicControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TopicService topicService;

    Topic mockTopic = new Topic("test-id", "test-name", "test-description");

    String exampleTopicJson = "{\"id\": \"test-id\", \"name\": \"test-name\", \"description\": \"test-description\"}";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testShowTopic() throws Exception {
        when(
                topicService.getTopic(anyString())
        ).thenReturn(mockTopic);

        RequestBuilder requestBuilder = get("/topics/test-id").accept(APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        String expectedResponse = "{id:test-id,name:test-name,description:test-description}";

        JSONAssert.assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString(), false);
    }

    @Test
    public void testCreateTopic() throws Exception {
        doNothing().when(topicService).addTopic(mockTopic);
        RequestBuilder requestBuilder = post("/topics")
                .accept(APPLICATION_JSON)
                .content(exampleTopicJson)
                .contentType(APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}