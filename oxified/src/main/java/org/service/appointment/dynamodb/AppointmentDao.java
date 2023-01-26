package main.java.org.service.appointment.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import main.java.org.exceptions.InvalidAttributeValueException;
import main.java.org.service.appointment.dynamodb.models.Appointment;

import javax.inject.Inject;

public class AppointmentDao {
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public AppointmentDao (DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Appointment getAppointment(String appointmentId, String date) {
        return dynamoDBMapper.load(Appointment.class, appointmentId, date);
    }

    public Appointment saveAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new InvalidAttributeValueException();
        }
        this.dynamoDBMapper.save(appointment);
        return appointment;
    }
}
