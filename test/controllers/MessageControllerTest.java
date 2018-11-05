package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import model.MessageInput;
import org.json.JSONObject;
import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;
import play.test.WithApplication;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static play.test.Helpers.POST;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.route;

public class MessageControllerTest  extends WithApplication{


    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }


    @Test
    public void testList() throws Exception {


        JsonNode json = Json.toJson(new MessageInput("ABC"));


        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(POST)
                .bodyJson(json)
                .uri("/backend/print");

        Result result = route(app, request);

        System.out.println(contentAsString(result));

        assertEquals("printed ABC to terminal",contentAsString(result));


    }
}
