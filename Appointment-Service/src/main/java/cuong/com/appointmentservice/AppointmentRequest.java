package cuong.com.appointmentservice;

public class AppointmentRequest {
    private String patientName;
    private Long doctorId;
    private String reason;

    // Getters và Setters
    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public Long getDoctorId() { return doctorId; }
    public void setDoctorId(Long doctorId) { this.doctorId = doctorId; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}
