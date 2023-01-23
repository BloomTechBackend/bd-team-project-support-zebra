package main.java.org.service.appointment.converters;

import main.java.org.service.appointment.dynamodb.models.Appointment;
import main.java.org.service.appointment.dynamodb.models.Booking;
import main.java.org.service.appointment.models.AppointmentModel;
import main.java.org.service.appointment.models.BookingModel;

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

    public BookingModel toBookingModel(Booking booking) {
        return BookingModel.builder()
                .withBookingId(booking.getBookingId())
                .withAppointmentList(booking.getAppointmentList())
                .withAppointmentCount(booking.getAppointmentCount())
                .build();
    }
}
