package com.doctor.doctorservice.controller;

import com.doctor.doctorservice.exception.ResourceNotFoundException;
import com.doctor.doctorservice.models.SharedInfo;
import com.doctor.doctorservice.serviceImpl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

public abstract class GenericControllerImpl<T extends SharedInfo, S extends GenericServiceImpl<T,Long>> implements GenericController<T, Long> {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected S servicio;

    @PostMapping("")
    public CompletableFuture<ResponseEntity> save(@RequestBody T entityModel){
        return servicio.save(entityModel).thenApply(ResponseEntity::ok);
    }

    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity>  getOne(@RequestBody Long id){
        return servicio.getById(id).thenApply(ResponseEntity::ok);
    }
    @GetMapping("")
    public CompletableFuture<ResponseEntity> getAll(){
        return servicio.getAll().thenApply(ResponseEntity::ok);
    }

    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity> update(@RequestBody T entityModel,@PathVariable Long id){

        return servicio.update(entityModel, id).thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity> delete(@PathVariable Long id){
        if(servicio.getById(id)==null){
            return CompletableFuture.completedFuture(new ResourceNotFoundException("Doctor","Id",id)).thenApply(ResponseEntity::ok);
        }
        return servicio.delete(id).thenApply(ResponseEntity::ok);
    }
}

