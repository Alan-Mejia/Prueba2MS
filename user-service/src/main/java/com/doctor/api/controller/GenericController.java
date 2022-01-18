package com.doctor.api.controller;

import com.doctor.api.models.SharedInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

public interface GenericController <T extends SharedInfo,ID extends Serializable>{
    CompletableFuture<ResponseEntity> getAll();
    CompletableFuture<ResponseEntity> getOne(@PathVariable ID id);
    CompletableFuture<ResponseEntity> save(@RequestBody T entityModel);
    CompletableFuture<ResponseEntity> update(@RequestBody T entityModel,@PathVariable ID id);
    CompletableFuture<ResponseEntity> delete(@PathVariable ID id);
}
