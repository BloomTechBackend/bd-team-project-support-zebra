package main.java.org.service.appointment.models.requests;

import java.util.Objects;

public class AddAppointmentToBookingRequest {
    private String id;
    private String appointmentId;
    private String date;
    private boolean queueNext;

    public  AddAppointmentToBookingRequest() {

    }

    public AddAppointmentToBookingRequest(String id, String appointmentId, String date, boolean queueNext) {
        this.id = id;
        this.appointmentId = appointmentId;
        this.date = date;
        this.queueNext = queueNext;
    }

    public AddAppointmentToBookingRequest(Builder builder) {
        this.id = builder.id;
        this.appointmentId = builder.appointmentId;
        this.date = builder.date;
        this.queueNext = builder.queueNext;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public boolean isQueueNext() {
        return queueNext;
    }

    public void setQueueNext(boolean queueNext) {
        this.queueNext = queueNext;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddAppointmentToBookingRequest)) return false;
        AddAppointmentToBookingRequest that = (AddAppointmentToBookingRequest) o;
        return queueNext == that.queueNext && id.equals(that.id) && appointmentId.equals(that.appointmentId) && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, appointmentId, date, queueNext);
    }

    @Override
    public String toString() {
        return "AddAppointmentToBookingRequest{" +
                "id='" + id + '\'' +
                ", appointmentId='" + appointmentId + '\'' +
                ", date='" + date + '\'' +
                ", queueNext=" + queueNext +
                '}';
    }

    public static final class Builder {
        private String id;
        private String appointmentId;
        private String date;
        private boolean queueNext;

        private Builder(){

        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withAppointmentId(String appointmentId) {
            this.appointmentId = appointmentId;
            return this;
        }

        public Builder withDate(String date) {
            this.date = date;
            return this;
        }

        public Builder withQueueNext(boolean queueNext) {
            this.queueNext = queueNext;
            return this;
        }

        public AddAppointmentToBookingRequest build() {
            return new AddAppointmentToBookingRequest(this);
        }
    }
}
