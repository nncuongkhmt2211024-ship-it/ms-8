package cuong.com.appointmentservice;

import java.time.LocalDateTime;

public class ApiResponseError {
    private String message;
    private int status;
    private String error;
    private LocalDateTime timestamp;

    public ApiResponseError(String message, int status, String error, LocalDateTime timestamp) {
        this.message = message;
        this.status = status;
        this.error = error;
        this.timestamp = timestamp;
    }

    // Bắt buộc phải có các Getter để Spring Boot có thể chuyển thành JSON
    public String getMessage() { return message; }
    public int getStatus() { return status; }
    public String getError() { return error; }
    public LocalDateTime getTimestamp() { return timestamp; }
}