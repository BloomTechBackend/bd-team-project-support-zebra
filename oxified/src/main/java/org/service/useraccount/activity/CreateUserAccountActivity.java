package main.java.org.service.useraccount.activity;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.org.service.useraccount.converter.ModelConverter;
import main.java.org.service.useraccount.dynamodb.UserAccountDao;
import main.java.org.service.useraccount.dynamodb.model.UserAccount;
import main.java.org.service.useraccount.model.request.CreateUserAccountRequest;
import main.java.org.service.useraccount.model.result.CreateUserAccountResult;
import main.java.org.service.useraccount.util.UserAccountServiceUtils;

import javax.inject.Inject;

public class CreateUserAccountActivity implements RequestHandler<CreateUserAccountRequest, CreateUserAccountResult> {

    private final UserAccountDao userAccountDao;
    @Inject
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
        userAccount.setEmail(createUserAccountRequest.getEmail());
        userAccount.setPassword(createUserAccountRequest.getPassword());
        userAccount.setUserType(createUserAccountRequest.getUserType());
        userAccount.setStatus(createUserAccountRequest.getStatus());
        userAccount.setLastName(createUserAccountRequest.getLastName());
        userAccount.setFirstName(createUserAccountRequest.getFirstName());
        userAccount.setUaId(UserAccountServiceUtils.generateUaId());
        return CreateUserAccountResult.builder()
                .withUserAccount(new ModelConverter().toUserAccountModel(userAccountDao.saveUserAccount(userAccount)))
                .build();
    }
}
