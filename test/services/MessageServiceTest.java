package services;

import model.MessageInput;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MessageServiceTest {

    @Test
    public void testLogToTerminal(){
        MessageService service = new MessageService();
        MessageInput input = new MessageInput("ABC");
        assertEquals("printed ABC to terminal", service.logToTerminal(input));
    }
}
