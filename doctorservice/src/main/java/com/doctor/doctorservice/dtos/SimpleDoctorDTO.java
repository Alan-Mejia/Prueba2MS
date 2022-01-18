package com.doctor.doctorservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class SimpleDoctorDTO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;


    @Column(name = "UserID")
    private Integer userdId;

    @Column(name="Fee")
    private Float fee;


    @Column(name="SpecialtyID")
    private Integer specialtyId;


    @Column(name="ShiftID")
    private Integer shiftId;


    @Column(name="Status")
    private Integer status;

    public SimpleDoctorDTO(Long id, Integer userdId, Float fee, Integer specialtyId, Integer shiftId, Integer status) {
        this.id = id;
        this.userdId = userdId;
        this.fee = fee;
        this.specialtyId = specialtyId;
        this.shiftId = shiftId;
        this.status = status;
    }

    public SimpleDoctorDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }

    public Integer getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Integer specialtyId) {
        this.specialtyId = specialtyId;
    }

    public Integer getShiftId() {
        return shiftId;
    }

    public void setShiftId(Integer shiftId) {
        this.shiftId = shiftId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserdId() {
        return userdId;
    }

    public void setUserdId(Integer userdId) {
        this.userdId = userdId;
    }
}
