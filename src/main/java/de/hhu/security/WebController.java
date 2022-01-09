package de.hhu.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String getIndex(Model model){
        return "index";
    }

    @GetMapping("/home")
    public String getHomePage(){
        return "home";
    }
}
