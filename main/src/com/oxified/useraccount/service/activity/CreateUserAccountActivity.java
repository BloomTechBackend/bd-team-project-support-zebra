package com.oxified.useraccount.service.activity;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.oxified.useraccount.service.converter.ModelConverter;
import com.oxified.useraccount.service.dynamodb.UserAccountDao;
import com.oxified.useraccount.service.dynamodb.model.UserAccount;
import com.oxified.useraccount.service.model.request.CreateUserAccountRequest;
import com.oxified.useraccount.service.model.result.CreateUserAccountResult;
import com.oxified.useraccount.service.util.UserAccountServiceUtils;

public class CreateUserAccountActivity implements RequestHandler<CreateUserAccountRequest, CreateUserAccountResult> {

    private final UserAccountDao userAccountDao;

    public CreateUserAccountActivity(UserAccountDao userAccountDao) {
        this.userAccountDao = userAccountDao;
    }

    @Override
    public CreateUserAccountResult handleRequest(CreateUserAccountRequest createUserAccountRequest, Context context) {

//        if(!UserAccountServiceUtils.isValidString(createPlaylistRequest.getName()) ||
//                !UserAccountServiceUtils.isValidString(createPlaylistRequest.getCustomerId())) {
//            throw new InvalidAttributeValueException();
//        }

        UserAccount userAccount = new UserAccount();
        userAccount.setFirstName(createUserAccountRequest.getFirstName());
        userAccount.setUaId(UserAccountServiceUtils.generateUaId());
        return CreateUserAccountResult.builder()
                .withUserAccount(new ModelConverter().toUserAccountModel(userAccountDao.saveUserAccount(userAccount)))
                .build();
    }
}
