package cuong.com.appointmentservice.controller;

import cuong.com.appointmentservice.AppointmentRequest;
import cuong.com.appointmentservice.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public Object createAppointment(@RequestBody AppointmentRequest request) {
        return appointmentService.addAppointment(request);
    }
}