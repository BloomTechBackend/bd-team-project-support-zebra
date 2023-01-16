package com.oxified.useraccount.service.activity;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.oxified.useraccount.service.model.request.CreateUserAccountRequest;
import com.oxified.useraccount.service.model.result.CreateUserAccountResult;

public class CreateUserAccountActivity implements RequestHandler<CreateUserAccountRequest, CreateUserAccountResult> {


    @Override
    public CreateUserAccountResult handleRequest(CreateUserAccountRequest createUserAccountRequest, Context context) {
        return null;
    }
}
