package controllers;

import connectors.BackendConnector;
import forms.MessageInputForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Result;
import javax.inject.Inject;
import javax.inject.Singleton;
import static play.mvc.Results.ok;
import play.Logger;

@Singleton
public class MessageController {

    private final Form<MessageInputForm> form;


    @Inject
    public MessageController(FormFactory formFactory) {
        this.form = formFactory.form(MessageInputForm.class);
    }

    public Result submitMessage() {

        Logger.debug("submit message");
        final Form<MessageInputForm> boundForm = form.bindFromRequest();

        if (boundForm.hasErrors()) {
            play.Logger.ALogger logger = play.Logger.of(getClass());
            logger.error("errors = {}", boundForm.errors());
            return ok(views.html.homepage.render(form));
        } else {
            MessageInputForm data = boundForm.get();
            BackendConnector.sendMessage(data.getMessage());
            return ok(views.html.homepage.render(form));
        }
    }



    public Result getHomepage() {
        return ok(views.html.homepage.render(form));
    }
}
