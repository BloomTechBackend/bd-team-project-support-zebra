package main.java.org.service.appointment.converters;

import main.java.org.service.appointment.dynamodb.models.Appointment;
import main.java.org.service.appointment.models.AppointmentModel;

public class ModelConverter {
    public AppointmentModel toAppointmentModel(Appointment appointment) {
        return AppointmentModel.builder()
                .withAppointmentId(appointment.getAppointmentId())
                .withDate(appointment.getDate())
                .withTime(appointment.getTime())
                .withServiceId(appointment.getServiceId())
                .withAddressId(appointment.getAddressId())
                .withStatus(appointment.getStatus())
                .build();
    }
}
