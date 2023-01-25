package main.java.org.dependency;

import dagger.Component;
import main.java.org.service.appointment.activity.*;
import main.java.org.service.spservice.acitivity.CreateServiceActivity;
import main.java.org.service.spservice.acitivity.GetServiceActivity;
import main.java.org.service.useraccount.activity.CreateUserAccountActivity;
import main.java.org.service.useraccount.activity.GetUserAccountActivity;
import main.java.org.service.useraccount.activity.UpdateUserAccountActivity;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {
    CreateUserAccountActivity provideCreateUserAccountActivity();
    GetUserAccountActivity provideGetUserAccountActivity();
    UpdateUserAccountActivity provideUpdateUserAccountActivity();
    GetServiceActivity provideGetServiceActivity();
    CreateServiceActivity provideCreateService();
    //  DON
    AddAppointmentToBookingActivity provideAddAppointmentToBookingActivity();
    CreateBookingActivity provideCreateBookingActivity();
    GetBookingActivity provideGetBookingActivity();
    GetBookingAppointmentsActivity provideGetBookingAppointmentsActivity();
    UpdateBookingAppointmentActivity provideUpdateBookingAppointmentActivity();
}
