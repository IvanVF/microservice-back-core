package backcore.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckAliveController {

    @GetMapping("/")
    public String CheckAlive() {
        return "Microservice back core works!";
    }
}
