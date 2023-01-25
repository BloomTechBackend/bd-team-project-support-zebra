package main.java.org.service.appointment.models.results;

import main.java.org.service.appointment.models.AppointmentModel;

import java.util.List;

public class AddAppointmentToBookingResult {
    private List<AppointmentModel> appointmentModelList;

    public AddAppointmentToBookingResult(Builder builder) {
        this.appointmentModelList = builder.appointmentModelList;
    }

    public List<AppointmentModel> getAppointmentModelList() {
        return appointmentModelList;
    }

    public void setAppointmentModelList(List<AppointmentModel> appointmentModelList) {
        this.appointmentModelList = appointmentModelList;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private List<AppointmentModel> appointmentModelList;

        public Builder withAppointmentModelList(List<AppointmentModel> appointmentModelList) {
            this.appointmentModelList = appointmentModelList;
            return this;
        }

        public AddAppointmentToBookingResult build() {
            return new AddAppointmentToBookingResult(this);
        }
    }
}
