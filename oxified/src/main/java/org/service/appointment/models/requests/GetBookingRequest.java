package main.java.org.service.appointment.models.requests;

import com.amazonaws.services.dynamodbv2.model.Get;

import java.util.Objects;

public class GetBookingRequest {
    private String id;

    public GetBookingRequest() {

    }

    public GetBookingRequest(Builder builder) {
        this.id = builder.id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetBookingRequest)) return false;
        GetBookingRequest that = (GetBookingRequest) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GetBookingRequest{" +
                "id='" + id + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private Builder() {

        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public GetBookingRequest builder() {
            return new GetBookingRequest(this);
        }
    }
}
