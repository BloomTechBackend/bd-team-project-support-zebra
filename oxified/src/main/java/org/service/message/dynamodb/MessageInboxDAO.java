package main.java.org.service.message.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class MessageInboxDAO {
    private final DynamoDBMapper dynamoDBMapper;

    public MessageInboxDAO(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }
}
