package main.java.org.dependency;

import dagger.Component;
<<<<<<< HEAD
import main.java.org.service.appointment.activity.*;
import main.java.org.service.message.activity.CreateMessageActivity;
import main.java.org.service.message.activity.CreateMessageInboxIdActivity;
import main.java.org.service.message.activity.GetInboxPerLoggedInUserActivity;
import main.java.org.service.message.activity.GetMessagesPerInboxIdActivity;
=======
>>>>>>> ana
import main.java.org.service.spservice.acitivity.CreateServiceActivity;
import main.java.org.service.spservice.acitivity.GetAllServicesPerSPActivity;
import main.java.org.service.spservice.acitivity.GetServiceActivity;
import main.java.org.service.spservice.acitivity.UpdateServiceActivity;
import main.java.org.service.useraccount.activity.CreateUserAccountActivity;
import main.java.org.service.useraccount.activity.GetUserAccountActivity;
import main.java.org.service.useraccount.activity.UpdateUserAccountActivity;
import main.java.org.service.useraccount.activity.UserAuthenticationActivity;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {
    CreateUserAccountActivity provideCreateUserAccountActivity();
    GetUserAccountActivity provideGetUserAccountActivity();
    UpdateUserAccountActivity provideUpdateUserAccountActivity();
    GetServiceActivity provideGetServiceActivity();
    CreateServiceActivity provideCreateService();
    UpdateServiceActivity provideUpdateServiceActivity();
    GetAllServicesPerSPActivity provideGetAllServicesPerSPActivity();
<<<<<<< HEAD
    AddAppointmentToBookingActivity provideAddAppointmentToBookingActivity();
    CreateBookingActivity provideCreateBookingActivity();
    GetBookingActivity provideGetBookingActivity();
    GetBookingAppointmentsActivity provideGetBookingAppointmentsActivity();
    UpdateBookingAppointmentActivity provideUpdateBookingAppointmentActivity();
    CreateMessageInboxIdActivity provideCreateMessageInboxActivity();
    CreateMessageActivity provideCreateMessageActivity();

    GetInboxPerLoggedInUserActivity provideGetInboxPerLoggedInUserActivity();
    GetMessagesPerInboxIdActivity provideGetMessagesPerInboxIdActivity();
=======
    UserAuthenticationActivity provideUserAuthenticationActivity();

>>>>>>> ana

}
