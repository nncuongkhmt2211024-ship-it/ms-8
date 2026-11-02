package cuong.com.doctorservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

    @GetMapping("/api/doctors/check")
    public String checkStatus() {
        return "Doctor-Service (8082) đã hồi sinh và đang hoạt động bình thường!";
    }
}