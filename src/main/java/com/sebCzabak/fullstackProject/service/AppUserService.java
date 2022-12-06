package com.sebCzabak.fullstackProject.service;

import com.sebCzabak.fullstackProject.model.AppUser;
import com.sebCzabak.fullstackProject.repo.EmployeeRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {
    public AppUserService(EmployeeRepository employeeRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.employeeRepository = employeeRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    private final static String USER_NOT_FOUND="user with email %s not found";
    private final EmployeeRepository employeeRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return employeeRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException(
                        String.format(USER_NOT_FOUND,email)));
    }
    public String singUpUser(AppUser appUser){
        boolean employeeExists = employeeRepository
                .findByEmail(appUser.getEmail())
                .isPresent();
        if (employeeExists) {
            throw new IllegalStateException("email already taken");
        }
        String encodePassword = bCryptPasswordEncoder
                .encode(appUser.getPassword());
        appUser.setPassword(encodePassword);
        employeeRepository.save(appUser);

        return "it works";
    }
}
