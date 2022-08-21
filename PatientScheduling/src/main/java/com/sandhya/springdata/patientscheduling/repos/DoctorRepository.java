package com.sandhya.springdata.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;

import com.sandhya.springdata.patientscheduling.entities.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}
