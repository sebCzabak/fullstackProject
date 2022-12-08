package com.sebCzabak.fullstackProject.model;


import com.sebCzabak.fullstackProject.registration.token.ConfirmationToken;
import com.sebCzabak.fullstackProject.registration.token.ConfirmationTokenService;
import com.sebCzabak.fullstackProject.repo.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
public class EmployeeService implements UserDetailsService {
    public EmployeeService(EmployeeRepository employeeRepository, BCryptPasswordEncoder bCryptPasswordEncoder,ConfirmationTokenService confirmationTokenServic) {
        this.employeeRepository = employeeRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.confirmationTokenService =confirmationTokenServic;
    }

    private final static String USER_NOT_FOUND="user with email %s not found";
    private final EmployeeRepository employeeRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return employeeRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException(
                        String.format(USER_NOT_FOUND,email)));
    }
    @Transactional
    public String singUpUser(Employee employee){
        boolean employeeExists = employeeRepository
                .findByEmail(employee.getEmail())
                .isPresent();
        if (employeeExists) {
            throw new IllegalStateException("email already taken");
        }
        String encodePassword = bCryptPasswordEncoder
                .encode(employee.getPassword());
        employee.setPassword(encodePassword);
        employeeRepository.save(employee);
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                employee
        );
        confirmationTokenService.saveConfirmationToken(
                confirmationToken
        );

        return token;
    }


}

