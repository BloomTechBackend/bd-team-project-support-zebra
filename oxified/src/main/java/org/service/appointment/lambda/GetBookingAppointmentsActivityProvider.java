package main.java.org.service.appointment.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.org.service.appointment.models.requests.GetBookingAppointmentsRequest;
import main.java.org.service.appointment.models.results.GetBookingAppointmentsResult;
import main.java.org.service.dependency.DaggerServiceComponent;
import main.java.org.service.dependency.ServiceComponent;

public class GetBookingAppointmentsActivityProvider
        implements RequestHandler<GetBookingAppointmentsRequest, GetBookingAppointmentsResult> {
    private static ServiceComponent dagger = DaggerServiceComponent.create();

    public GetBookingAppointmentsActivityProvider() {
    }

    @Override
    public GetBookingAppointmentsResult handleRequest(GetBookingAppointmentsRequest request, Context context) {
        return dagger.provideGetBookingAppointmentsActivity().handleRequest(request, context);
    }
}
