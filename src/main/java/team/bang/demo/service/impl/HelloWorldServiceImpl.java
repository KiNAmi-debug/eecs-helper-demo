package team.bang.demo.service.impl;

import org.springframework.stereotype.Component;
import team.bang.demo.service.HelloWorldService;

@Component
public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String sayHello() {
        return "Thank you, BanG Dream!";
    }
}
