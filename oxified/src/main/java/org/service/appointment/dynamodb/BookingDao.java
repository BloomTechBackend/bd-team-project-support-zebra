package main.java.org.service.appointment.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import main.java.org.service.appointment.dynamodb.models.Booking;
import main.java.org.service.appointment.exceptions.InvalidAttributeValueException;

import javax.inject.Inject;

public class BookingDao {
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public BookingDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Booking getBooking(String bookingId){
        Booking booking = this.dynamoDBMapper.load(Booking.class, bookingId);
        if (booking == null) {
            throw new InvalidAttributeValueException("Could not find playlist with id " + bookingId);
        }
        return booking;
    }

    public Booking saveBooking(Booking booking) throws InvalidAttributeValueException {
        if (booking == null) {
            throw new InvalidAttributeValueException();
        }
        this.dynamoDBMapper.save(booking);
        return booking;
    }
}