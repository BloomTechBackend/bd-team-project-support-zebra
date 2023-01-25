package main.java.org.service.appointment.models.results;

import main.java.org.service.appointment.models.AppointmentModel;

public class UpdateBookingAppointmentResult {
    private AppointmentModel appointment;

    public UpdateBookingAppointmentResult(Builder builder) {
        this.appointment = builder.appointment;
    }

    public AppointmentModel getAppointment() {
        return appointment;
    }

    public void setAppointment(AppointmentModel appointment) {
        this.appointment = appointment;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private AppointmentModel appointment;

        public Builder withAppointment(AppointmentModel appointment) {
            this.appointment = appointment;
            return this;
        }

        public UpdateBookingAppointmentResult build() {
            return new UpdateBookingAppointmentResult(this);
        }
    }
}
