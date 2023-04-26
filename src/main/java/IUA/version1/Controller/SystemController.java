package IUA.version1.Controller;

import IUA.version1.Controller.Chat.Message;
import IUA.version1.Controller.Chat.Output;
import IUA.version1.Ws.MessageTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/system", method = RequestMethod.POST)
public class SystemController {

    @Autowired
    private MessageTemplate template;

    @RequestMapping("/broadcast")
    public Output broadcast(@RequestBody Message message) {
        Output outputMessage = new Output(new Date().toString(), message);
        template.broadcast(outputMessage);
        return outputMessage;
    }

    @RequestMapping("/send/{user}")
    public Output broadcast(@PathVariable("user") String user, @RequestBody Message message) {
        Output output = new Output(new Date().toString(), message);
        template.sendMsgToUser(user, output);
        return output;
    }

}
