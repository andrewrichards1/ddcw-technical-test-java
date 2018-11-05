package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import model.MessageInput;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Singleton;

import services.MessageService;
import utils.RestUtils;
import play.Logger;


@Singleton
public class MessageController extends Controller {

    @Inject
    private MessageService messageService;

    public Result printMessage() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return badRequest(RestUtils.createResponse(
                    "Expecting Json data", false));
        }
        MessageInput input = (MessageInput) Json.fromJson(json, MessageInput.class);
        Logger.debug("Got " + input.getMessage());


        return ok(messageService.logToTerminal(input));
    }


}
