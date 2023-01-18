package main.java.org.services.useraccount.activity;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.org.services.useraccount.converter.ModelConverter;
import main.java.org.services.useraccount.dynamodb.UserAccountDao;
import main.java.org.services.useraccount.dynamodb.model.UserAccount;
import main.java.org.services.useraccount.model.request.CreateUserAccountRequest;
import main.java.org.services.useraccount.model.result.CreateUserAccountResult;
import main.java.org.services.useraccount.util.UserAccountServiceUtils;

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
