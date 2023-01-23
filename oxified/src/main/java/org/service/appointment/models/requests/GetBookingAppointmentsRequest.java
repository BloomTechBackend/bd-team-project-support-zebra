package main.java.org.service.appointment.models.requests;

import java.util.Objects;

public class GetBookingAppointmentsRequest {
    private String bookingId;

    public GetBookingAppointmentsRequest() {

    }

    public GetBookingAppointmentsRequest(String bookingId) {
        this.bookingId = bookingId;
    }

    public GetBookingAppointmentsRequest(Builder builder) {
        this.bookingId = builder.bookingId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetBookingAppointmentsRequest)) return false;
        GetBookingAppointmentsRequest that = (GetBookingAppointmentsRequest) o;
        return Objects.equals(bookingId, that.bookingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId);
    }

    @Override
    public String toString() {
        return "GetBookingAppointmentsRequest{" +
                "bookingId='" + bookingId + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class  Builder {
        private String bookingId;

        private Builder() {

        }

        public Builder withBookingId(String bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public GetBookingAppointmentsRequest build() {
            return new GetBookingAppointmentsRequest(this);
        }
    }
}
