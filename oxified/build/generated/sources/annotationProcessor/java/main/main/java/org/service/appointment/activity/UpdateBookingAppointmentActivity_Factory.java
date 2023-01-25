package main.java.org.service.appointment.activity;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import main.java.org.service.appointment.dynamodb.AppointmentDao;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class UpdateBookingAppointmentActivity_Factory implements Factory<UpdateBookingAppointmentActivity> {
  private final Provider<AppointmentDao> appointmentDaoProvider;

  public UpdateBookingAppointmentActivity_Factory(Provider<AppointmentDao> appointmentDaoProvider) {
    this.appointmentDaoProvider = appointmentDaoProvider;
  }

  @Override
  public UpdateBookingAppointmentActivity get() {
    return newInstance(appointmentDaoProvider.get());
  }

  public static UpdateBookingAppointmentActivity_Factory create(
      Provider<AppointmentDao> appointmentDaoProvider) {
    return new UpdateBookingAppointmentActivity_Factory(appointmentDaoProvider);
  }

  public static UpdateBookingAppointmentActivity newInstance(AppointmentDao appointmentDao) {
    return new UpdateBookingAppointmentActivity(appointmentDao);
  }
}
