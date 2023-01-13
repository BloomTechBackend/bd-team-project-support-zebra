package com.oxified.message.service.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class MessageInboxDAO {
    private final DynamoDBMapper dynamoDBMapper;

    public MessageInboxDAO(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }
}
