package com.doctor.api.models;


import lombok.Builder;
import javax.validation.constraints.NotEmpty;


import javax.persistence.*;

@Entity
@Table(name = "users")
@Builder
public class User extends SharedInfo{

    @Column(name="Status")
    private Integer status;

    @Column(name="Name")
    @NotEmpty(message = "Name should not be empty")
    private String name;

    @Column(name="Lastname")
    @NotEmpty(message = "Lastname should not be empty")
    private String lastName;

    @Column(name="Surname")
    @NotEmpty(message = "Surname should not be empty")
    private String surname;

    @Column(name="Email")
    @NotEmpty(message = "Email should not be empty")
    private String email;

    @Column(name="Role")
    //@NotEmpty(message = "Role should not be empty")
    private Integer role;

    @Column(name="Username")
    @NotEmpty(message = "Username should not be empty")
    private String username;


    public User(Integer status, String name, String lastName, String surname, String email, Integer role, String username) {
        this.status = status;
        this.name = name;
        this.lastName = lastName;
        this.surname = surname;
        this.email = email;
        this.role = role;
        this.username = username;
    }

    public User(){}


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
