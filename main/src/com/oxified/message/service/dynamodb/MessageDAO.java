package com.oxified.message.service.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.oxified.message.service.dynamodb.models.Message;

import javax.inject.Inject;

public class MessageDAO {
    private final DynamoDBMapper dynamoDBMapper;
    @Inject
    public MessageDAO(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Message saveMessage(Message message) {
        try {
            dynamoDBMapper.save(message);
        } catch (Exception e) {
            System.out.println(e);
        }
        return message;
    }

}
