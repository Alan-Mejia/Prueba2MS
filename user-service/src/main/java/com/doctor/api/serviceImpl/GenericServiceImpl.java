package com.doctor.api.serviceImpl;


import com.doctor.api.exception.ResourceNotFoundException;
import com.doctor.api.models.SharedInfo;
import com.doctor.api.respository.GenericRepository;
import com.doctor.api.service.GenericService;
import org.springframework.scheduling.annotation.Async;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public abstract class GenericServiceImpl<T extends SharedInfo, ID extends Serializable> implements GenericService<T, ID> {
    protected GenericRepository<T,ID> genericRepository;

    public GenericServiceImpl(GenericRepository<T, ID> genericRepository) {
        this.genericRepository = genericRepository;
    }

    @Async("asyncExecutor")
    @Override
    @Transactional
    public CompletableFuture<T> save(T entityModel) {
        System.out.println( Thread.currentThread().getName());
        return CompletableFuture.completedFuture(genericRepository.save(entityModel));
    }

    @Async("asyncExecutor")
    @Override
    @Transactional
    public CompletableFuture<List<T>> getAll() {
        System.out.println( Thread.currentThread().getName());
        return CompletableFuture.completedFuture(genericRepository.findAll());
    }

    @Async("asyncExecutor")
    @Override
    @Transactional
    public CompletableFuture<T> getById(ID id) {
        System.out.println( Thread.currentThread().getName());
        return CompletableFuture.completedFuture(genericRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity", "Id", id)));
    }

    @Async("asyncExecutor")
    @Override
    @Transactional
    public CompletableFuture<T> update(T entityModel, ID id) {
        System.out.println( Thread.currentThread().getName());
        T existingUser = genericRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","Id",id));
        return CompletableFuture.completedFuture(genericRepository.save(entityModel));
    }

    @Async("asyncExecutor")
    @Override
    @Transactional
    public CompletableFuture<Boolean> delete(ID id) {
        System.out.println( Thread.currentThread().getName());
        genericRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","Id",id));
        genericRepository.deleteById(id);
        return CompletableFuture.completedFuture(true);
    }

}
