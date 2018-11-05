package services;

import model.MessageInput;
import play.Logger;

public class MessageService {

    public String logToTerminal(MessageInput input) {
        Logger.debug(input.getMessage());
        return String.format("printed %s to terminal", input.getMessage());
    }
}
