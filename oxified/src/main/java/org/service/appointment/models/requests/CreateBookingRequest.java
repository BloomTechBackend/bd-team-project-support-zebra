package main.java.org.service.appointment.models.requests;

import main.java.org.service.appointment.dynamodb.models.Appointment;
import main.java.org.service.appointment.util.ServiceUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CreateBookingRequest {
    private String bookingId = ServiceUtils.generateId();
    private List<Appointment> appointmentList = new ArrayList<>();
    private Integer appointmentCount;

    public CreateBookingRequest(List<Appointment> appointmentList, Integer appointmentCount) {
        this.appointmentList = appointmentList;
        this.appointmentCount = appointmentCount;
    }

    public CreateBookingRequest() {

    }

    public CreateBookingRequest(Builder builder) {
        this.appointmentList = builder.appointmentList;
        this.appointmentCount = builder.appointmentCount;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public Integer getAppointmentCount() {
        return appointmentCount;
    }

    public void setAppointmentCount(Integer appointmentCount) {
        this.appointmentCount = appointmentCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateBookingRequest)) return false;
        CreateBookingRequest that = (CreateBookingRequest) o;
        return bookingId.equals(that.bookingId) && appointmentList.equals(that.appointmentList) && appointmentCount.equals(that.appointmentCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, appointmentList, appointmentCount);
    }

    @Override
    public String toString() {
        return "CreateBookingRequest{" +
                "bookingId='" + bookingId + '\'' +
                ", appointmentList=" + appointmentList +
                ", appointmentCount=" + appointmentCount +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private List<Appointment> appointmentList = new ArrayList<>();
        private Integer appointmentCount;

        public Builder withAppointmentList(List<Appointment> appointmentList) {
            this.appointmentList = appointmentList;
            return this;
        }

        public Builder withAppointmentCount(Integer appointmentCount) {
            this.appointmentCount = appointmentCount;
            return this;
        }

        public CreateBookingRequest build() {
            return new CreateBookingRequest(this);
        }
    }
}
