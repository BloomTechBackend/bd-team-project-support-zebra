package main.java.org.service.dependency;

import dagger.Component;
import main.java.org.service.appointment.activity.*;
import main.java.org.service.useraccount.activity.CreateUserAccountActivity;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {
    CreateUserAccountActivity provideCreateUserAccountActivity();
//    GetUserAccountActivity provideGetUserAccountActivity();
//    UpdateUserAccountActivity provideUpdateUserAccountActivity();

    //  DON
    AddAppointmentToBookingActivity provideAddAppointmentToBookingActivity();
    CreateBookingActivity provideCreateBookingActivity();
    GetBookingActivity provideGetBookingActivity();
    GetBookingAppointmentsActivity provideGetBookingAppointmentsActivity();
    UpdateBookingAppointmentActivity provideUpdateBookingAppointmentActivity();

}
