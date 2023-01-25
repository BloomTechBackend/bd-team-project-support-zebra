package main.java.org.service.appointment.activity;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
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
public final class GetBookingAppointmentsActivity_Factory implements Factory<GetBookingAppointmentsActivity> {
  private final Provider<BookingDao> bookingDaoProvider;

  public GetBookingAppointmentsActivity_Factory(Provider<BookingDao> bookingDaoProvider) {
    this.bookingDaoProvider = bookingDaoProvider;
  }

  @Override
  public GetBookingAppointmentsActivity get() {
    return newInstance(bookingDaoProvider.get());
  }

  public static GetBookingAppointmentsActivity_Factory create(
      Provider<BookingDao> bookingDaoProvider) {
    return new GetBookingAppointmentsActivity_Factory(bookingDaoProvider);
  }

  public static GetBookingAppointmentsActivity newInstance(BookingDao bookingDao) {
    return new GetBookingAppointmentsActivity(bookingDao);
  }
}
