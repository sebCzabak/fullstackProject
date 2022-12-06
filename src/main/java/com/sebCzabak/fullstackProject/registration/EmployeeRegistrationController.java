package com.sebCzabak.fullstackProject.registration;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/registration")
public class EmployeeRegistrationController {
    public EmployeeRegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    private RegistrationService registrationService;


    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }
}
