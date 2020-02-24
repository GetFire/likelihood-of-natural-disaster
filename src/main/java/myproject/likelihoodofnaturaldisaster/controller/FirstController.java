package myproject.likelihoodofnaturaldisaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/")
public class FirstController {
    @GetMapping
    public String home(@RequestParam(required = false, defaultValue = "Hello") String message, Model model) {
        model.addAttribute("name", message);

        return "hello";
    }

}