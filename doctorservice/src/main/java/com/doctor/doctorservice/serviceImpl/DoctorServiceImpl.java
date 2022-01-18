package com.doctor.doctorservice.serviceImpl;

import com.doctor.doctorservice.dtos.GenericMapperDTO;
import com.doctor.doctorservice.dtos.SimpleDoctorDTO;
import com.doctor.doctorservice.exception.ResourceNotFoundException;
import com.doctor.doctorservice.models.Doctor;
import com.doctor.doctorservice.repository.DoctorRepository;
import com.doctor.doctorservice.repository.GenericRepository;
import com.doctor.doctorservice.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class DoctorServiceImpl extends GenericServiceImpl<Doctor,Long> implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    static GenericMapperDTO genericMapperDTO = GenericMapperDTO.singleInstance();

    public DoctorServiceImpl(GenericRepository<Doctor, Long> genericRepository) {
        super(genericRepository);
    }

    @Async("asyncExecutor")
    @Transactional
    public CompletableFuture<List<SimpleDoctorDTO>> getAllDTO(){
        System.out.println(Thread.currentThread().getName());
        List<Doctor> entities = doctorRepository.findAll();
        List<SimpleDoctorDTO> dtos = new ArrayList<>();
        for(Doctor doctor : entities){
            SimpleDoctorDTO userSimpleDTO;
            userSimpleDTO = genericMapperDTO.mapToSimpleDoctorDTO(doctor);
            dtos.add(userSimpleDTO);
        }
        return CompletableFuture.completedFuture(dtos);
    }

    @Async("asyncExecutor")
    @Transactional
    public CompletableFuture<SimpleDoctorDTO> getOneDoctorDTO(Long id){
        Doctor existingDoctorr = doctorRepository.getById(id);
        ModelMapper modelMapper = new ModelMapper();
        SimpleDoctorDTO userDTO = modelMapper.map(existingDoctorr, SimpleDoctorDTO.class);
        return CompletableFuture.completedFuture(userDTO);
    }

    @Async("asyncExecutor")
    @Transactional
    public CompletableFuture<Doctor> updateDoctor(Doctor doctor, Long id){
        Doctor existingDoctor = doctorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Doctorr","Id",id));
        existingDoctor.setModificationTime(new Date());

        existingDoctor.setFee(doctor.getFee());
        existingDoctor.setSpecialtyId(doctor.getSpecialtyId());
        existingDoctor.setUserdId(doctor.getUserdId());
        existingDoctor.setShiftId(doctor.getShiftId());
        return CompletableFuture.completedFuture(doctorRepository.save(existingDoctor));
    }


    @Async("asyncExecutor")
    @Transactional
    public CompletableFuture<Boolean> deleteUser(Long id){
        Doctor existingDoctor = doctorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Doctorr","Id",id));
        existingDoctor.setStatus(2);
        return CompletableFuture.completedFuture(true);
    }

    @Async("asyncExecutor")
    @Transactional
    public CompletableFuture<Doctor> registerDoctor(Doctor doctorr){
        doctorr.setModificationTime(new Date());
        doctorr.setCreationTime(new Date());
        doctorr.setStatus(1);
        return CompletableFuture.completedFuture(doctorRepository.save(doctorr));
    }

}
