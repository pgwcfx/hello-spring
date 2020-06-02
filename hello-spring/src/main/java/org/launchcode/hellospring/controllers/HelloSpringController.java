package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloSpringController {

    //Responds to /hello
    /*@GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "Hello, Spring!";
    }*/

    //lives /hello/goodbye
    @GetMapping("hello/goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //lives /hello
    //Handles request of the form /hello?name=LaunchCode&languages=English
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value="hello")
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String languages, Model model){
        switch (languages) {
            case "Spanish":
                String greeting1 = "Hola, " + name + "!";
                model.addAttribute("greeting",greeting1);
                return "hello";
            case "French":
                String greeting2 = "Bonjour, " + name + "!";
                model.addAttribute("greeting",greeting2);
                return "hello";
            case "German":
                String greeting3 = "Guten Tag, " + name + "!";
                model.addAttribute("greeting",greeting3);
                return "hello";
            case "Italian":
                String greeting4 = "Ciao, " + name + "!";
                model.addAttribute("greeting",greeting4);
                return "hello";
            case "Portuguese":
                String greeting5 = "Ola, " + name + "!";
                model.addAttribute("greeting",greeting5);
                return "hello";
        }
        model.addAttribute("greeting","Hello, " + name + "!");
        return "hello";
    }

    //Handles request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){
        model.addAttribute("greeting","Hello, " + name + "!");
        return "hello";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    @GetMapping("hello/entry")
    @ResponseBody
    public String createMessage(){
        return "<html>" +
                "<h1>Controllers and Routing</h1>" +
                "<body>" +
                "<h2>languages</h2>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "<label for='language-select'>Choose a language:" +
                "</label>" +
                "<ol>" +
                    "<li>" +
                        "<select name='languages' id='language-select'>" +
                            "<option value='English'>" +
                            "English</option>" +
                            "<option value='French'>" +
                            "French</option>" +
                            "<option value='Spanish'>" +
                            "Spanish</option>" +
                            "<option value='German'>" +
                            "German</option>" +
                            "<option value='Italian'>" +
                            "Italian</option>" +
                            "<option value='Portuguese'>" +
                            "Portuguese</option>" +
                        "</select>" +
                    "</li>" +
                "</ol>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List <String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names",names);
        return "hello-list";
    }

}
