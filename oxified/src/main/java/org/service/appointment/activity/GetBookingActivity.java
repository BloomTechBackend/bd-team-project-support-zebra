package main.java.org.service.appointment.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.org.service.appointment.converters.ModelConverter;
import main.java.org.service.appointment.dynamodb.BookingDao;
import main.java.org.service.appointment.dynamodb.models.Booking;
import main.java.org.service.appointment.models.BookingModel;
import main.java.org.service.appointment.models.requests.GetBookingRequest;
import main.java.org.service.appointment.models.results.GetBookingResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.management.InvalidAttributeValueException;

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
        try {
            Booking booking = bookingDao.getBooking(request.getId());
            BookingModel bookingModel = new ModelConverter().toBookingModel(booking);
            return GetBookingResult.builder()
                    .withBooking(bookingModel)
                    .build();
        } catch (InvalidAttributeValueException e) {
            throw new RuntimeException(e);
        }

    }
}
