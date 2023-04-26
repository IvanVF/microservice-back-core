package backcore.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckAliveController {

    @GetMapping("/")
    public String checkAlive() {
        return "Microservice back core works!";
    }
}
