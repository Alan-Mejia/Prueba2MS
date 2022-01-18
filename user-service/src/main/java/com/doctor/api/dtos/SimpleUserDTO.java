package com.doctor.api.dtos;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SimpleUserDTO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name="Username")
    private String username;


    @Column(name="Role")
    private Integer role;


    @Column(name="Name")
    private String name;


    @Column(name="Email")
    private String email;


//    public SimpleUserDTO(Long id, String username, String email) {
//        this.id = id;
//        this.username = username;
//        this.email = email;
//    }

    public SimpleUserDTO(Long id, String username, Integer role, String name, String email) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.name = name;
        this.email = email;
    }

    public  SimpleUserDTO(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
