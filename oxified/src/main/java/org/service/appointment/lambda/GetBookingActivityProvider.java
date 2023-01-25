package main.java.org.service.appointment.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.org.service.appointment.models.requests.GetBookingRequest;
import main.java.org.service.appointment.models.results.GetBookingResult;
import main.java.org.service.dependency.DaggerServiceComponent;
import main.java.org.service.dependency.ServiceComponent;

public class GetBookingActivityProvider implements RequestHandler<GetBookingRequest, GetBookingResult> {
    private static ServiceComponent dagger = DaggerServiceComponent.create();

    public GetBookingActivityProvider() {
    }

    @Override
    public GetBookingResult handleRequest(GetBookingRequest request, Context context) {
        return dagger.provideGetBookingActivity().handleRequest(request, context);
    }
}
