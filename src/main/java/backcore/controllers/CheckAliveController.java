package backcore.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckAliveController {

    @GetMapping(path = "/")
    public String appWorkingAnswer() {
        return "Microservice back core works!";
    }
}
