package com.sebCzabak.fullstackProject.model;

import com.sebCzabak.fullstackProject.model.tasks.Task;
import jakarta.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Entity
public class Employee implements UserDetails {
    @Id
    @SequenceGenerator(
            name="employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"

    )
    private Long id;
    private String firstName;
    private String UserName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private EmployeeRole employeeRole;
    private Boolean locked =false;
    private Boolean enabled = false;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUserName() {
        return UserName;
    }
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EmployeeRole getAppUserRole() {
        return employeeRole;
    }

    public void setAppUserRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(firstName, employee.firstName) && Objects.equals(UserName, employee.UserName) && Objects.equals(email, employee.email) && Objects.equals(password, employee.password) && employeeRole == employee.employeeRole && Objects.equals(locked, employee.locked) && Objects.equals(enabled, employee.enabled);
    }

    public Employee() {
    }

    public Employee(String firstName, String UserName, String email, String password, EmployeeRole employeeRole) {
        this.firstName = firstName;
        this.UserName = UserName;
        this.email = email;
        this.password = password;
        this.employeeRole = employeeRole;
           }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, UserName, email, password, employeeRole, locked, enabled);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(employeeRole.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }


}
