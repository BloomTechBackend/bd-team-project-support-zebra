package com.oxified.useraccount.service.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.oxified.useraccount.service.dynamodb.model.UserAccount;

public class UserAccountDao {
    private final DynamoDBMapper dynamoDBMapper;

    public UserAccountDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public UserAccount getUserAccount(String uaId, String userType) {
        return dynamoDBMapper.load(UserAccount.class, uaId, userType);
    }
}
