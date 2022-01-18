package com.doctor.doctorservice.repository;

import com.doctor.doctorservice.models.Doctor;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository
        extends GenericRepository<Doctor,Long> {

    //Specific QUERYS
    /*
     * List<Doctor> findByName(String name);
     *
     *
     *
     * */

}
