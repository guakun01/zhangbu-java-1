package github.guakun01.zhangbujava1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping("/hi")
    public String sayHello(String name) {
        return String.format("hi, %s", name);
    }
}
