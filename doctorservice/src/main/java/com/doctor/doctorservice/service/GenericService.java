package com.doctor.doctorservice.service;

import com.doctor.doctorservice.models.SharedInfo;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface GenericService <T extends SharedInfo, ID extends Serializable>{
    CompletableFuture<T> save(T entityModel);
    CompletableFuture<List<T>> getAll();
    CompletableFuture<T> getById(ID id);
    CompletableFuture<T> update(T entityModel,ID id);
    CompletableFuture<Boolean> delete(ID id);

}
