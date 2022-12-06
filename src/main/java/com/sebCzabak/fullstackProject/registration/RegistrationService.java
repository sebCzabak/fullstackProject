package com.sebCzabak.fullstackProject.registration;

import com.sebCzabak.fullstackProject.model.AppUser;
import com.sebCzabak.fullstackProject.model.AppUserRole;
import com.sebCzabak.fullstackProject.service.AppUserService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    public RegistrationService(EmailValidator emailValidator, AppUserService appUserService) {
        this.emailValidator = emailValidator;
        this.appUserService = appUserService;
    }

    private EmailValidator emailValidator;
    private final AppUserService appUserService;
    public String register(RegistrationRequest request) {
       boolean isValidEmail = emailValidator.test(request.getEmail());
       if(!isValidEmail){
           throw new IllegalStateException("email not valid");
       }
        return appUserService.singUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}
