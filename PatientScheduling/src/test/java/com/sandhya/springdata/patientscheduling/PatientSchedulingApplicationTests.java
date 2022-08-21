package com.sandhya.springdata.patientscheduling;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sandhya.springdata.patientscheduling.entities.Appointment;
import com.sandhya.springdata.patientscheduling.entities.Doctor;
import com.sandhya.springdata.patientscheduling.entities.Insurence;
import com.sandhya.springdata.patientscheduling.entities.Patient;
import com.sandhya.springdata.patientscheduling.repos.AppointmentRepository;
import com.sandhya.springdata.patientscheduling.repos.DoctorRepository;
import com.sandhya.springdata.patientscheduling.repos.PatientRepository;

@SpringBootTest
class PatientSchedulingApplicationTests {

	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Test
	public void testCreateDoctor() {
		Doctor doctor = new Doctor();
		doctor.setFirstName("Bharat");
		doctor.setLastName("Mishra");
		doctor.setSpeciality("Eye");
		doctorRepository.save(doctor);
	}
	
	@Test
	public void testcreatePatient() {
		
		
		Patient patient = new Patient();
		patient.setFirstName("Doug");
		patient.setLastName("Bailey");
		patient.setPhone("9887865421");
		
		Insurence insurence = new Insurence();
		insurence.setProviderName("Blue Cross Blue Shield");
		insurence.setCopay(20d);
		patient.setInsurence(insurence);
		
		Optional<Doctor> doctor = doctorRepository.findById(1L);
		List<Doctor> doctors = Arrays.asList(doctor.get());
		patient.setDoctors(doctors);
		
		patientRepository.save(patient);
	}
	
	@Test
	public void testCreateAppointment() {
		
		Appointment appointment = new Appointment();
		Timestamp appointmentTime = new Timestamp(new Date().getTime());
		appointment.setAppointmentTime(appointmentTime);
		appointment.setReason("I have a problem");
		appointment.setStarted(true);
		
		appointment.setPatient(patientRepository.findById(1L).get());
		appointment.setDoctor(doctorRepository.findById(1L).get());
		
		appointmentRepository.save(appointment);
	}

}
