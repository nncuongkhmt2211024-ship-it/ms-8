package cuong.com.appointmentservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// Cấu hình gọi sang Doctor-Service ở port 8082
@FeignClient(name = "doctor-service", url = "http://localhost:8082")
public interface DoctorClient {
    @GetMapping("/api/doctors/check")
    String checkDoctor();
}