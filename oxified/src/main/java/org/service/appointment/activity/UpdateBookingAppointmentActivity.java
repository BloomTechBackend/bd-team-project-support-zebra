package main.java.org.service.appointment.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.org.exceptions.InvalidAttributeChangeException;
import main.java.org.exceptions.InvalidAttributeValueException;
import main.java.org.service.appointment.converters.ModelConverter;
import main.java.org.service.appointment.dynamodb.AppointmentDao;
import main.java.org.service.appointment.dynamodb.models.Appointment;
import main.java.org.exceptions.AppointmentNotFoundException;
import main.java.org.service.appointment.models.requests.UpdateBookingAppointmentRequest;
import main.java.org.service.appointment.models.results.UpdateBookingAppointmentResult;
import main.java.org.service.appointment.util.ServiceUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.Objects;

public class UpdateBookingAppointmentActivity
        implements RequestHandler<UpdateBookingAppointmentRequest, UpdateBookingAppointmentResult> {
    private final Logger log = LogManager.getLogger();
    private final AppointmentDao appointmentDao;

    @Inject
    public UpdateBookingAppointmentActivity(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    @Override
    public UpdateBookingAppointmentResult handleRequest(UpdateBookingAppointmentRequest request, Context context) {
        log.info("Received UpdateBookingAppointmentRequest {}", request);
        if (ServiceUtils.isValidString(request.getAppointmentId()) || ServiceUtils.isValidString(request.getServiceId())
            || ServiceUtils.isValidString(request.getAddressId())) {
            throw new InvalidAttributeValueException("Invalid characters found, please try again.");
        }
        Appointment appointment = appointmentDao.getAppointment(request.getAppointmentId(), request.getDate());
        if (appointment == null) {
            throw new AppointmentNotFoundException("Appointment not found.");
        }

        appointment.setDate(request.getDate());
        appointment.setTime(request.getTime());
        appointment.setAddressId(request.getAddressId());
        appointment.setStatus(request.getStatus());
        if (!Objects.equals(appointment.getServiceId(), request.getServiceId())) {
            throw new InvalidAttributeChangeException();
        }
        appointmentDao.saveAppointment(appointment);

        return UpdateBookingAppointmentResult.builder()
                .withAppointment(new ModelConverter().toAppointmentModel(appointment))
                .build();
    }
}
