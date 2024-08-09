package com.exponent.happ.service;

import com.exponent.happ.dto.Response;
import com.exponent.happ.entity.Appointment;

public interface AppointmentServiceI {

	Response bookAppointment(Appointment appointment,String usernumber);
}
