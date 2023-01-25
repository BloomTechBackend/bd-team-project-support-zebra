package main.java.org.service.dependency;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import main.java.org.service.appointment.activity.AddAppointmentToBookingActivity;
import main.java.org.service.appointment.activity.CreateBookingActivity;
import main.java.org.service.appointment.activity.GetBookingActivity;
import main.java.org.service.appointment.activity.GetBookingAppointmentsActivity;
import main.java.org.service.appointment.activity.UpdateBookingAppointmentActivity;
import main.java.org.service.appointment.dynamodb.AppointmentDao;
import main.java.org.service.appointment.dynamodb.BookingDao;
import main.java.org.service.useraccount.activity.CreateUserAccountActivity;
import main.java.org.service.useraccount.dynamodb.UserAccountDao;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerServiceComponent {
  private DaggerServiceComponent() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static ServiceComponent create() {
    return new Builder().build();
  }

  public static final class Builder {
    private DaoModule daoModule;

    private Builder() {
    }

    public Builder daoModule(DaoModule daoModule) {
      this.daoModule = Preconditions.checkNotNull(daoModule);
      return this;
    }

    public ServiceComponent build() {
      if (daoModule == null) {
        this.daoModule = new DaoModule();
      }
      return new ServiceComponentImpl(daoModule);
    }
  }

  private static final class ServiceComponentImpl implements ServiceComponent {
    private final ServiceComponentImpl serviceComponentImpl = this;

    private Provider<DynamoDBMapper> provideDBMapperProvider;

    private ServiceComponentImpl(DaoModule daoModuleParam) {

      initialize(daoModuleParam);

    }

    private UserAccountDao userAccountDao() {
      return new UserAccountDao(provideDBMapperProvider.get());
    }

    private BookingDao bookingDao() {
      return new BookingDao(provideDBMapperProvider.get());
    }

    private AppointmentDao appointmentDao() {
      return new AppointmentDao(provideDBMapperProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final DaoModule daoModuleParam) {
      this.provideDBMapperProvider = DoubleCheck.provider(DaoModule_ProvideDBMapperFactory.create(daoModuleParam));
    }

    @Override
    public CreateUserAccountActivity provideCreateUserAccountActivity() {
      return new CreateUserAccountActivity(userAccountDao());
    }

    @Override
    public AddAppointmentToBookingActivity provideAddAppointmentToBookingActivity() {
      return new AddAppointmentToBookingActivity(bookingDao(), appointmentDao());
    }

    @Override
    public CreateBookingActivity provideCreateBookingActivity() {
      return new CreateBookingActivity(bookingDao());
    }

    @Override
    public GetBookingActivity provideGetBookingActivity() {
      return new GetBookingActivity(bookingDao());
    }

    @Override
    public GetBookingAppointmentsActivity provideGetBookingAppointmentsActivity() {
      return new GetBookingAppointmentsActivity(bookingDao());
    }

    @Override
    public UpdateBookingAppointmentActivity provideUpdateBookingAppointmentActivity() {
      return new UpdateBookingAppointmentActivity(appointmentDao());
    }
  }
}
