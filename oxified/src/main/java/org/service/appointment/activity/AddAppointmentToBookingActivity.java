package main.java.org.service.appointment.activity;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.org.service.appointment.converters.ModelConverter;
import main.java.org.service.appointment.dynamodb.AppointmentDao;
import main.java.org.service.appointment.dynamodb.BookingDao;
import main.java.org.service.appointment.dynamodb.models.Appointment;
import main.java.org.service.appointment.dynamodb.models.Booking;
import main.java.org.service.appointment.models.AppointmentModel;
import main.java.org.service.appointment.models.requests.AddAppointmentToBookingRequest;
import main.java.org.service.appointment.models.results.AddAppointmentToBookingResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddAppointmentToBookingActivity
        implements RequestHandler<AddAppointmentToBookingRequest, AddAppointmentToBookingResult> {
    private final Logger log = LogManager.getLogger();
    private final BookingDao bookingDao;
    private final AppointmentDao appointmentDao;

    @Inject
    public AddAppointmentToBookingActivity(BookingDao bookingDao, AppointmentDao appointmentDao) {
        this.bookingDao = bookingDao;
        this.appointmentDao = appointmentDao;
    }

    @Override
    public AddAppointmentToBookingResult handleRequest(AddAppointmentToBookingRequest request, Context context) {
        log.info("Received AddAppointmentToBookingRequest {}", request);

        List<AppointmentModel> appointmentModelList = new LinkedList<>();
        AddAppointmentToBookingResult result;
        try {

            Appointment inputAppointment = appointmentDao.getAppointment(request.getAppointmentId(), request.getDate());
            AppointmentModel inputAppointmentModel = new ModelConverter().toAppointmentModel(inputAppointment);
            if (request.isQueueNext()) {
                appointmentModelList.add(0, inputAppointmentModel);
            } else {
                appointmentModelList.add(inputAppointmentModel);
            }

            Booking booking = bookingDao.getBooking(request.getId());

            List<Appointment> appointments = new ArrayList<>(booking.getAppointmentList());
            for (Appointment appointment : appointments ) {
                AppointmentModel appointmentModel = new ModelConverter().toAppointmentModel(appointment);
                appointmentModelList.add(appointmentModel);
            }
            result =AddAppointmentToBookingResult.builder()
                    .withAppointmentModelList(appointmentModelList)
                    .build();
        } catch (InvalidAttributeValueException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
