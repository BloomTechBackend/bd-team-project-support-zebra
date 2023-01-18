package main.java.org.services.useraccount.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import main.java.org.services.useraccount.dynamodb.model.UserAccount;

public class UserAccountDao {
    private final DynamoDBMapper dynamoDBMapper;

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
