package cuong.com.appointmentservice.service;

import cuong.com.appointmentservice.ApiResponseError;
import cuong.com.appointmentservice.AppointmentRequest;
import cuong.com.appointmentservice.client.DoctorClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;

@Service
public class AppointmentService {

    @Autowired
    private DoctorClient doctorClient;

    // Đổi tên fallbackMethod theo đúng yêu cầu
    @CircuitBreaker(name = "doctorServiceCB", fallbackMethod = "getDoctorFallback")
    public Object addAppointment(AppointmentRequest request) {
        // Cố tình gọi sang Doctor-Service (8082 đang tắt) để gây lỗi
        doctorClient.checkDoctor();

        return "Đặt lịch thành công cho: " + request.getPatientName();
    }

    // Hàm Fallback chuẩn (Lưu ý: Resilience4j yêu cầu tham số phải khớp với hàm gốc + Exception)
    public Object getDoctorFallback(AppointmentRequest request, Exception e) {
        System.out.println("Lỗi bắt được (ngắn gọn): " + e.getClass().getSimpleName());

        // Trả về đối tượng JSON lỗi chuyên nghiệp
        return new ApiResponseError(
                "Hiện tại không thể kiểm tra thông tin bác sĩ, vui lòng thử lại sau vài giây",
                503,
                "Doctor Service Error",
                LocalDateTime.now()
        );
    }
}