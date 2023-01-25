package main.java.org.service.appointment.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.org.exceptions.InvalidAttributeValueException;
import main.java.org.service.appointment.converters.ModelConverter;
import main.java.org.service.appointment.dynamodb.BookingDao;
import main.java.org.service.appointment.dynamodb.models.Booking;
import main.java.org.exceptions.BookingNotFoundException;
import main.java.org.service.appointment.models.requests.GetBookingRequest;
import main.java.org.service.appointment.models.results.GetBookingResult;
import main.java.org.service.appointment.util.ServiceUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class GetBookingActivity implements RequestHandler<GetBookingRequest, GetBookingResult> {
    private final Logger log = LogManager.getLogger();
    private final BookingDao bookingDao;

    @Inject
    public GetBookingActivity(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    @Override
    public GetBookingResult handleRequest(GetBookingRequest request, Context context) {
        log.info("Received GetBookingRequest {}", request);
        if (ServiceUtils.isValidString(request.getId())) {
            throw new InvalidAttributeValueException("Invalid characters found, please try again.");
        }
        Booking booking = bookingDao.getBooking(request.getId());
        if (booking == null) {
            throw new BookingNotFoundException("Booking not found");
        }
        return GetBookingResult.builder()
                .withBooking(new ModelConverter().toBookingModel(booking))
                .build();
    }
}
