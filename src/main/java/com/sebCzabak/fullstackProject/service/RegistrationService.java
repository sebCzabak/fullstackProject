package com.sebCzabak.fullstackProject.service;

import com.sebCzabak.fullstackProject.exception.UserNotFoundException;
import com.sebCzabak.fullstackProject.model.Employee;
import com.sebCzabak.fullstackProject.model.EmployeeRole;
import com.sebCzabak.fullstackProject.registration.EmailValidator;
import com.sebCzabak.fullstackProject.registration.RegistrationRequest;
import com.sebCzabak.fullstackProject.registration.token.ConfirmationTokenService;
import com.sebCzabak.fullstackProject.repo.EmployeeRepository;
import com.sebCzabak.fullstackProject.model.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;

@Service
public class RegistrationService {
    public RegistrationService(EmailValidator emailValidator, EmployeeService employeeService, EmployeeRepository employeeRepository, ConfirmationTokenService confirmationTokenService) {
        this.emailValidator = emailValidator;
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
        this.confirmationTokenService = confirmationTokenService;
    }

    private EmailValidator emailValidator;
    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;
    private final ConfirmationTokenService confirmationTokenService;
    public String register(RegistrationRequest request) {
       boolean isValidEmail = emailValidator.test(request.getEmail());
       if(!isValidEmail){
           throw new IllegalStateException("email not valid");
       }
        return employeeService.singUpUser(
                new Employee(
                        request.getFirstName(),
                        request.getUserName(),
                        request.getEmail(),
                        request.getPassword(),
                        EmployeeRole.USER

                )
        );
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));

    }

    @Transactional
    public void updateEmployee(Long id, String firstName, String UserName, String email, String password) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));

        if(firstName !=null && firstName.length() > 0 &&!Objects.equals(employee.getFirstName(),firstName)){
            employee.setFirstName(firstName);
        }
        if(UserName !=null && UserName.length() > 0 &&!Objects.equals(employee.getUserName(),UserName)){
            employee.setUserName(UserName);
        }
        if(email !=null && email.length() > 0 &&!Objects.equals(employee.getEmail(),email)){
            employee.setEmail(email);
        }
        if(password !=null && password.length() > 0&&!Objects.equals(employee.getPassword(),password)){
            employee.setPassword(password);
        }
    }
    public void deleteEmployee(Long id) {
        boolean exists = employeeRepository.existsById(id);
                if(!exists){
                    throw new UserNotFoundException(id);
                }
                employeeRepository.deleteById(id);
    }



}
