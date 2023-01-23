package main.java.org.service.appointment.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.org.service.appointment.converters.ModelConverter;
import main.java.org.service.appointment.dynamodb.BookingDao;
import main.java.org.service.appointment.dynamodb.models.Booking;
import main.java.org.service.appointment.models.BookingModel;
import main.java.org.service.appointment.models.requests.CreateBookingRequest;
import main.java.org.service.appointment.models.results.CreateBookingResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.management.InvalidAttributeValueException;

public class CreateBookingActivity implements RequestHandler<CreateBookingRequest, CreateBookingResult> {
    private final Logger log = LogManager.getLogger();
    private final BookingDao bookingDao;

    @Inject
    public CreateBookingActivity(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    @Override
    public CreateBookingResult handleRequest(CreateBookingRequest request, Context context) {
        log.info("Received CreateBookingActing {}", request);
        Booking booking = new Booking();
        booking.setBookingId(request.getBookingId());
        booking.setAppointmentList(request.getAppointmentList());
        booking.setAppointmentCount(request.getAppointmentCount());
        try {
            bookingDao.saveBooking(booking);
        } catch (InvalidAttributeValueException e) {
            throw new RuntimeException(e);
        }
        BookingModel bookingModel = new ModelConverter().toBookingModel(booking);
        return CreateBookingResult.builder()
                .withBooking(bookingModel)
                .build();
    }
}
