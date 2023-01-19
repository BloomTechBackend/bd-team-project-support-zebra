package main.java.org.service.useraccount.dynamodb;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import main.java.org.service.useraccount.dynamodb.model.UserAccount;

import javax.inject.Inject;

public class UserAccountDao {
    private final DynamoDBMapper dynamoDBMapper;
    @Inject
    public UserAccountDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public UserAccount getUserAccount(String uaId, String userType) {
        return dynamoDBMapper.load(UserAccount.class, uaId, userType);
    }

    public UserAccount saveUserAccount(UserAccount userAccount) {
        dynamoDBMapper.save(userAccount);
        return userAccount;
    }
}
