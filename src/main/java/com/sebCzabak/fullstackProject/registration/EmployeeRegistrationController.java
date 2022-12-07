package com.sebCzabak.fullstackProject.registration;


import com.sebCzabak.fullstackProject.model.AppUser;
import com.sebCzabak.fullstackProject.repo.EmployeeRepository;
import com.sebCzabak.fullstackProject.service.RegistrationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api")
@CrossOrigin("http://localhost:3000")
public class EmployeeRegistrationController {

    public EmployeeRegistrationController(RegistrationService registrationService, EmployeeRepository employeeRepository) {
        this.registrationService = registrationService;

    }

    private RegistrationService registrationService;

    @GetMapping("/home")
    public String home(){
        return "This is a Home page";
    }
    @GetMapping("/AdminPage")
    public String admin(){
        return "This is an admin page!";
    }


    @GetMapping("/users")
    List<AppUser> getAllEmployees(){
        return registrationService.findAll();
    }


    @PostMapping("/registration")
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

    @GetMapping("/user/{id}")
    AppUser getEmployeeById(@PathVariable Long id){
        return registrationService.findById(id);
    }
    @PutMapping("/upUser/{id}")
   public void updateEmployee(
           @PathVariable Long id,
           @RequestParam(required = false)String firstName,
           @RequestParam(required = false)String lastName,
           @RequestParam(required = false)String email,
           @RequestParam(required = false)String password)
    {
        registrationService.updateEmployee(id,firstName,lastName,email,password);
    }

    @DeleteMapping("/delUser/{id}")
    public void deleteEmployee(@PathVariable Long id){
        registrationService.deleteEmployee(id);
    }
//    @PostMapping("/login/{email,password}")
//    public String loginEmployee(@RequestBody LoginRequest loginRequest){
//        return registrationService.login()
//    }

}
