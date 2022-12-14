package github.guakun01.zhangbujava1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping("/hi")
    public String sayHi(@RequestParam("name") String name) {
        return String.format("hi, %s", name);
    }
}
