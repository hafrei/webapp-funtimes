package displaypage.controllers;

import displaypage.model.Holder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by hfreiburger1 on 15-02-23.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public ModelAndView servePics() throws IOException{

        ModelAndView modelAndView = new ModelAndView("runner");
        String greeting = "Hello everybody!";
        String chat = "This is from MainController";
        int filler = 57;

        Holder holder = new Holder(greeting, chat, filler);

        modelAndView.addObject(holder);

        return modelAndView;
    }

}
