package main.java.org.service.appointment.activity;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import main.java.org.service.appointment.dynamodb.AppointmentDao;
import main.java.org.service.appointment.dynamodb.BookingDao;

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
public final class AddAppointmentToBookingActivity_Factory implements Factory<AddAppointmentToBookingActivity> {
  private final Provider<BookingDao> bookingDaoProvider;

  private final Provider<AppointmentDao> appointmentDaoProvider;

  public AddAppointmentToBookingActivity_Factory(Provider<BookingDao> bookingDaoProvider,
      Provider<AppointmentDao> appointmentDaoProvider) {
    this.bookingDaoProvider = bookingDaoProvider;
    this.appointmentDaoProvider = appointmentDaoProvider;
  }

  @Override
  public AddAppointmentToBookingActivity get() {
    return newInstance(bookingDaoProvider.get(), appointmentDaoProvider.get());
  }

  public static AddAppointmentToBookingActivity_Factory create(
      Provider<BookingDao> bookingDaoProvider, Provider<AppointmentDao> appointmentDaoProvider) {
    return new AddAppointmentToBookingActivity_Factory(bookingDaoProvider, appointmentDaoProvider);
  }

  public static AddAppointmentToBookingActivity newInstance(BookingDao bookingDao,
      AppointmentDao appointmentDao) {
    return new AddAppointmentToBookingActivity(bookingDao, appointmentDao);
  }
}
