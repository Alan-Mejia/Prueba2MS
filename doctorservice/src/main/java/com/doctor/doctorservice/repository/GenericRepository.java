package com.doctor.doctorservice.repository;

import com.doctor.doctorservice.models.SharedInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean//Won't be able to create an instance
public interface GenericRepository<T extends SharedInfo, ID extends Serializable>
        extends JpaRepository<T,ID> {
}
