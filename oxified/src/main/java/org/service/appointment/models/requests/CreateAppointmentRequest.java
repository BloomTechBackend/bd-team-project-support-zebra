package main.java.org.service.appointment.models.requests;

import main.java.org.service.appointment.util.ServiceUtils;

import java.util.Objects;

public class CreateAppointmentRequest {
    private String appointmentId = ServiceUtils.generateId();
    private String date;
    private String time;
    private String serviceId;
    private String addressId;
    private String status;

    public CreateAppointmentRequest() {

    }

    public CreateAppointmentRequest(String date, String time,
                                    String serviceId, String addressId, String status) {
        this.date = date;
        this.time = time;
        this.serviceId = serviceId;
        this.addressId = addressId;
        this.status = status;
    }

    public CreateAppointmentRequest(Builder builder) {
        this.date = builder.date;
        this.time = builder.time;
        this.serviceId = builder.serviceId;
        this.addressId = builder.addressId;
        this.status = builder.status;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateAppointmentRequest)) return false;
        CreateAppointmentRequest that = (CreateAppointmentRequest) o;
        return appointmentId.equals(that.appointmentId) && date.equals(that.date) && time.equals(that.time) && serviceId.equals(that.serviceId) && addressId.equals(that.addressId) && status.equals(that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId, date, time, serviceId, addressId, status);
    }

    @Override
    public String toString() {
        return "CreateAppointmentRequest{" +
                "appointmentId='" + appointmentId + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", addressId='" + addressId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String date;
        private String time;
        private String serviceId;
        private String addressId;
        private String status;

        public Builder withDate(String date) {
            this.date = date;
            return this;
        }

        public Builder withTime(String time) {
            this.time = time;
            return this;
        }

        public Builder withServiceId(String serviceId) {
            this.serviceId = serviceId;
            return this;
        }

        public Builder withAddressId(String addressId) {
            this.addressId = addressId;
            return this;
        }

        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public CreateAppointmentRequest build() {
            return new CreateAppointmentRequest(this);
        }
    }
}
