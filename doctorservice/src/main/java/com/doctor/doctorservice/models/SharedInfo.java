package com.doctor.doctorservice.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class SharedInfo implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name="Creationtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;

    @Column(name="Modificationtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationTime;


    @Column(name="Usermodifier")
    private String userModifier;

    @Column(name="Usercreator")
    private String userCreator;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    public String getUserModifier() {
        return userModifier;
    }

    public void setUserModifier(String userModifier) {
        this.userModifier = userModifier;
    }

    public String getUserCreator() {
        return userCreator;
    }

    public void setUserCreator(String userCreator) {
        this.userCreator = userCreator;
    }
}
