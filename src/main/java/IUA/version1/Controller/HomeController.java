package IUA.version1.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
@CrossOrigin(value = "http://localhost:8080")
public class HomeController {

    //@Value("${welcome.message}")
    private String welcomeMsg = "Pressed the button & Let's Chat!";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome(Model model) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy.M.d - HH:mm:ss EEE");
        //String WelcomeDate = dateFormat.format(new Date());
        //DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.getDefault());
        model.addAttribute("serverTime", dateFormat.format(new Date()));
        model.addAttribute("welcomeMsg", welcomeMsg);
        return "home";
    }

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String getChat(Model model) {
        return "chat";
    }

}
