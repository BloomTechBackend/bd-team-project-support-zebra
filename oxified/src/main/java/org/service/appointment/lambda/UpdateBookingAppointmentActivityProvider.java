//package main.java.org.service.appointment.lambda;
//
//import com.amazonaws.services.lambda.runtime.Context;
//import com.amazonaws.services.lambda.runtime.RequestHandler;
//import main.java.org.dependency.DaggerServiceComponent;
//import main.java.org.dependency.ServiceComponent;
//import main.java.org.service.appointment.models.requests.UpdateBookingAppointmentRequest;
//import main.java.org.service.appointment.models.results.UpdateBookingAppointmentResult;
//
//public class UpdateBookingAppointmentActivityProvider
//        implements RequestHandler<UpdateBookingAppointmentRequest, UpdateBookingAppointmentResult> {
//    private static ServiceComponent dagger = DaggerServiceComponent.create();
//
//    public UpdateBookingAppointmentActivityProvider() {
//    }
//
//    @Override
//    public UpdateBookingAppointmentResult handleRequest(UpdateBookingAppointmentRequest request, Context context) {
//        return dagger.provideUpdateBookingAppointmentActivity().handleRequest(request, context);
//    }
//}
