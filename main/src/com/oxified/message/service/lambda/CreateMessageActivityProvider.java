package com.oxified.message.service.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.oxified.message.service.dependency.ServiceComponent;
import com.oxified.message.service.models.results.CreateMessageResult;
import com.oxified.message.service.models.results.requests.CreateMessageRequest;


public class CreateMessageActivityProvider implements RequestHandler<CreateMessageRequest, CreateMessageResult> {

    /**
     * Handles a Lambda Function request
     *
     * @param createMessageRequest   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return The Lambda Function output
     */
    @Override
    public CreateMessageResult handleRequest(CreateMessageRequest createMessageRequest, Context context) {
        return  getApp().provideCreateMessageActivity().handleRequest(createMessageRequest, context);
    }

    private ServiceComponent getApp() {
        ServiceComponent serviceComponent = null;
        return serviceComponent;

    }
}
