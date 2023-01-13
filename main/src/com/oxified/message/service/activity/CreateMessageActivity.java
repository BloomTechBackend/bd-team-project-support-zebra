package com.oxified.message.service.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.oxified.message.service.models.requests.CreateMessageRequest;
import com.oxified.message.service.models.results.CreateMessageResult;

public class CreateMessageActivity implements RequestHandler<CreateMessageRequest, CreateMessageResult>{

    /**
     * Handles a Lambda Function request
     *
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return The Lambda Function output
     */
    @Override
    public CreateMessageResult handleRequest(CreateMessageRequest input, Context context) {
        return null;
    }
}
