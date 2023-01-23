package main.java.org.service.appointment.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.org.service.appointment.converters.ModelConverter;
import main.java.org.service.appointment.dynamodb.AppointmentDao;
import main.java.org.service.appointment.dynamodb.models.Appointment;
import main.java.org.service.appointment.models.AppointmentModel;
import main.java.org.service.appointment.models.requests.CreateAppointmentRequest;
import main.java.org.service.appointment.models.results.CreateAppointmentResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.management.InvalidAttributeValueException;

public class CreateAppointmentActivity implements RequestHandler<CreateAppointmentRequest, CreateAppointmentResult> {
    private final Logger log = LogManager.getLogger();
    private final AppointmentDao appointmentDao;

    @Inject
    public CreateAppointmentActivity(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    @Override
    public CreateAppointmentResult handleRequest(CreateAppointmentRequest request, Context context) {
        log.info("Received CreateAppointRequest {}", request);
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(request.getAppointmentId());
        appointment.setDate(request.getDate());
        appointment.setTime(request.getTime());
        appointment.setServiceId(request.getServiceId());
        appointment.setAddressId(request.getAddressId());
        appointment.setStatus(request.getStatus());
        try {
            appointmentDao.saveAppointment(appointment);
        } catch (InvalidAttributeValueException e) {
            throw new RuntimeException(e);
        }
        AppointmentModel appointmentModel = new ModelConverter().toAppointmentModel(appointment);
        return CreateAppointmentResult.builder()
                .withAppointment(appointmentModel)
                .build();
    }
}
