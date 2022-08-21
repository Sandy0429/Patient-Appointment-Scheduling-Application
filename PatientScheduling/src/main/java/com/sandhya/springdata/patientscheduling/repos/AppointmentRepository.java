package com.sandhya.springdata.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;

import com.sandhya.springdata.patientscheduling.entities.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
