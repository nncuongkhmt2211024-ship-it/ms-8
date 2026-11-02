package cuong.com.appointmentservice.service;

import cuong.com.appointmentservice.client.DoctorClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private DoctorClient doctorClient;

    // Tên doctorServiceCB phải gõ y hệt trong file properties
    @CircuitBreaker(name = "doctorServiceCB", fallbackMethod = "fallbackCheckDoctor")
    public String bookAppointment() {
        return doctorClient.checkDoctor();
    }

    // Hàm Fallback chạy khi Doctor-Service (8082) bị sập
    public String fallbackCheckDoctor(Exception e) {
        System.out.println("Lỗi bắt được (ngắn gọn): " + e.getClass().getSimpleName());
        return "Fallback: Doctor-Service hiện đang sập! Trả về dữ liệu dự phòng.";
    }
}