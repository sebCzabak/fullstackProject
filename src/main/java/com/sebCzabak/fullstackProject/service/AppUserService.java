package com.sebCzabak.fullstackProject.service;

import com.sebCzabak.fullstackProject.repo.EmployeeRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {
    public AppUserService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private final static String USER_NOT_FOUND="user with email %s not found";
    private final EmployeeRepository employeeRepository;
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return employeeRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException(
                        String.format(USER_NOT_FOUND,email)));
    }
}
