package com.doctor.doctorservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "doctors")
@Builder
public class Doctor extends SharedInfo{

    @Column(name = "Fee")
    private Float fee;

    @Column(name = "SpecialtyID")
    private Integer specialtyId;

    @Column(name = "UserID")
    private Integer userdId;

    @Column(name = "ShiftID")
    private Integer shiftId;

    @Column(name="Status")
    private Integer status;

    public Doctor(Float fee, Integer specialtyId, Integer userdId, Integer shiftId, Integer status) {
        this.fee = fee;
        this.specialtyId = specialtyId;
        this.userdId = userdId;
        this.shiftId = shiftId;
        this.status = status;
    }

    public Doctor(){}

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

    public Integer getUserdId() {
        return userdId;
    }

    public void setUserdId(Integer userdId) {
        this.userdId = userdId;
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
}
