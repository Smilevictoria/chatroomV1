package IUA.version1.Controller.Chat;

import IUA.version1.Ws.MessageTemplate;
import IUA.version1.Ws.WebSocketSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class ChatController {

    @Autowired
    private WebSocketSessions sessions;

    @MessageMapping("/chat")
    @SendTo(MessageTemplate.BROADCAST_DESTINATION)
    public Output send(final Message message) throws Exception {
        final String time = new Date().toString();
        return new Output(time, message);
    }

}
