package com.doctor.doctorservice.controller;

import com.doctor.doctorservice.dtos.SimpleDoctorDTO;
import com.doctor.doctorservice.models.Doctor;
import com.doctor.doctorservice.serviceImpl.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/v1/doctors")
public class DoctorController extends GenericControllerImpl<Doctor, DoctorServiceImpl> {


    @Autowired
    private DoctorServiceImpl doctorService;

    @Override
    @GetMapping("")
    public CompletableFuture<ResponseEntity> getAll(){
        return doctorService.getAllDTO().thenApply(ResponseEntity::ok);
    }

    @Override
    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity> getOne(@PathVariable Long id){
        CompletableFuture<SimpleDoctorDTO> exists = doctorService.getOneDoctorDTO(id);
        return exists.thenApply(ResponseEntity::ok);
    }

    @PostMapping("")
    public CompletableFuture<ResponseEntity> save(@RequestBody Doctor doctor){
//        if(doctor == null){
//            return CompletableFuture.completedFuture(ResponseEntity.noContent().build());
//        }
        doctor.setModificationTime(new Date());
        doctor.setCreationTime(new Date());
        doctor.setStatus(1);
        return doctorService.save(doctor).thenApply(ResponseEntity::ok);
    }

    @Override
    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity> update(@RequestBody Doctor doctor, @PathVariable("id") Long id){
        return doctorService.updateDoctor(doctor,id).thenApply(ResponseEntity::ok);
    }


    @Override
    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity> delete(@PathVariable("id")Long id){
        return doctorService.deleteUser(id).thenApply(ResponseEntity::ok);
    }

}
