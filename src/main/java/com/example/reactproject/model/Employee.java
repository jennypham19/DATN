package com.example.reactproject.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="employee_id")
    private Long employee_id;

    @Column(name="fullname")
    private String fullname;

    @NotBlank
    @Size(max = 20)
    @Column(name = "username")
    private String username;


    @NotBlank
    @Size(max = 120)
    @Column(name = "password")
    private String password;


    @NotBlank
    @Size(max = 50)
    @Email
    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable (name = "user_roles",
            joinColumns =  @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id")
    )
    private Set<Roles> roles = new HashSet<>();

    public Employee() {
    }

    public Employee(String fullname, String username, String password,  String email) {
        this.fullname = fullname;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public  Long getEmployee_id() {return employee_id;}

    public  void  setEmployee_id(Long employee_id){ this.employee_id = employee_id;}

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
}
