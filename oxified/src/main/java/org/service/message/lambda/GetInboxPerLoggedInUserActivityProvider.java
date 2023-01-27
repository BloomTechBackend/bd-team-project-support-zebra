package main.java.org.service.message.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.org.dependency.DaggerServiceComponent;
import main.java.org.dependency.ServiceComponent;
import main.java.org.service.message.models.request.GetInboxPerLoggedInUserRequest;
import main.java.org.service.message.models.results.GetInboxPerLoggedInUserResult;

public class GetInboxPerLoggedInUserActivityProvider implements RequestHandler<GetInboxPerLoggedInUserRequest, GetInboxPerLoggedInUserResult> {

    /**
     * Handles a Lambda Function request
     *
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return The Lambda Function output
     */
    @Override
    public GetInboxPerLoggedInUserResult handleRequest(GetInboxPerLoggedInUserRequest input, Context context) {
       return getService().provideGetInboxPerLoggedInUserActivity().handleRequest(input,context);
    }
    private ServiceComponent getService() {
        ServiceComponent component = DaggerServiceComponent.create();
        return component;
    }
}
