package team.bang.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import team.bang.demo.service.HelloWorldService;

@RestController
//@RequestMapping("/")

public class HelloWorldController {
    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("/hello")
    public String helloWorld() {
        return helloWorldService.sayHello();
    }
}
