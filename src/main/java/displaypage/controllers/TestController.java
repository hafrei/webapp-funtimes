package displaypage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import displaypage.model.Holder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hfreiburger1 on 15-02-23.
 */
@Controller
public class TestController {

    @RequestMapping("/testing")
    public ModelAndView tester() throws IOException{

        ModelAndView modelAndView = new ModelAndView("testrunner");
        String greeting;
        String chat = "Inconceivable!";
        String cut;
        int filler = 0;
        List<Holder> listHolder = new ArrayList<>();


        while (filler != chat.length()){
            filler++;
            greeting = "Iteration: " + Integer.toString(filler);
            cut = chat.substring(filler -1, chat.length());

            System.out.println("Filler: " + filler);
            System.out.println("Greeting: " + greeting);
            System.out.println("Cut: " + cut);
            System.out.println("------");

            Holder holder = new Holder(greeting, cut, filler);
            listHolder.add(holder);

        }

        modelAndView.addObject("listHolder", listHolder);
        
        return modelAndView;
    }

}
