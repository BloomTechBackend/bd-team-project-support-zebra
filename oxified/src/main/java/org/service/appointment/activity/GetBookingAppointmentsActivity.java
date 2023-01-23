package main.java.org.service.appointment.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.org.service.appointment.converters.ModelConverter;
import main.java.org.service.appointment.dynamodb.BookingDao;
import main.java.org.service.appointment.dynamodb.models.Appointment;
import main.java.org.service.appointment.dynamodb.models.Booking;
import main.java.org.service.appointment.models.AppointmentModel;
import main.java.org.service.appointment.models.requests.GetBookingAppointmentsRequest;
import main.java.org.service.appointment.models.results.GetBookingAppointmentsResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.management.InvalidAttributeValueException;
import java.util.List;

public class GetBookingAppointmentsActivity
        implements RequestHandler<GetBookingAppointmentsRequest, GetBookingAppointmentsResult> {
    private final Logger log = LogManager.getLogger();
    private final BookingDao bookingDao;

    @Inject
    public GetBookingAppointmentsActivity(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    @Override
    public GetBookingAppointmentsResult handleRequest(GetBookingAppointmentsRequest request, Context context) {
        log.info("Received GetBookingAppointment {}", request);
        try {
            Booking booking = bookingDao.getBooking(request.getBookingId());
            List<Appointment> appointmentList = booking.getAppointmentList();
            List<AppointmentModel> appointmentModelList = new ModelConverter().toAppointmentModelList(appointmentList);
            return GetBookingAppointmentsResult.builder()
                    .withAppointmentList(appointmentModelList)
                    .build();
        } catch (InvalidAttributeValueException e) {
            throw new RuntimeException(e);
        }
    }
}
