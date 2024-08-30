package aleksey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "index";
    }

    @GetMapping("/new")
    public String index() {
        return "new";
    }
}
