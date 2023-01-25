package main.java.org.service.appointment.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.org.service.appointment.converters.ModelConverter;
import main.java.org.service.appointment.dynamodb.BookingDao;
import main.java.org.service.appointment.dynamodb.models.Booking;
import main.java.org.service.appointment.exceptions.InvalidAttributeValueException;
import main.java.org.service.appointment.models.BookingModel;
import main.java.org.service.appointment.models.requests.CreateBookingRequest;
import main.java.org.service.appointment.models.results.CreateBookingResult;
import main.java.org.service.appointment.util.ServiceUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

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
        if (ServiceUtils.isValidString(request.getBookingId())) {
            throw new InvalidAttributeValueException("Invalid characters found, please try again.");
        }
        Booking booking = new Booking();
        booking.setBookingId(request.getBookingId());
        booking.setAppointmentList(request.getAppointmentList());
        booking.setAppointmentCount(request.getAppointmentCount());
        bookingDao.saveBooking(booking);
        return CreateBookingResult.builder()
                .withBooking(new ModelConverter().toBookingModel(booking))
                .build();
    }
}
