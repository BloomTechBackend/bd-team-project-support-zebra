package main.java.org.service.appointment.activity;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.org.service.appointment.converters.ModelConverter;
import main.java.org.service.appointment.dynamodb.AppointmentDao;
import main.java.org.service.appointment.dynamodb.BookingDao;
import main.java.org.service.appointment.dynamodb.models.Appointment;
import main.java.org.service.appointment.dynamodb.models.Booking;
import main.java.org.exceptions.AppointmentNotFoundException;
import main.java.org.exceptions.BookingNotFoundException;
import main.java.org.service.appointment.models.AppointmentModel;
import main.java.org.service.appointment.models.requests.AddAppointmentToBookingRequest;
import main.java.org.service.appointment.models.results.AddAppointmentToBookingResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
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
        Booking booking = bookingDao.getBooking(request.getId());
        if (booking == null) {
            throw new BookingNotFoundException("Booking not found.");
        }
        List<Appointment> appointments = new ArrayList<>(booking.getAppointmentList());
        for (Appointment appointment : appointments ) {
            AppointmentModel appointmentModel = new ModelConverter().toAppointmentModel(appointment);
            appointmentModelList.add(appointmentModel);
        }
        Appointment inputAppointment = appointmentDao.getAppointment(request.getAppointmentId(), request.getDate());
        if (inputAppointment == null) {
            throw new AppointmentNotFoundException("Appointment not found.");
        }
        AppointmentModel inputAppointmentModel = new ModelConverter().toAppointmentModel(inputAppointment);
        if (request.isQueueNext()) {
            appointmentModelList.add(0, inputAppointmentModel);
        } else {
            appointmentModelList.add(inputAppointmentModel);
        }
        return AddAppointmentToBookingResult.builder()
                    .withAppointmentModelList(appointmentModelList)
                    .build();
    }
}
