package main.java.org.service.message.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import main.java.org.service.message.dynamodb.models.UserMessage;
import main.java.org.service.message.dynamodb.models.UserMessageInbox;

import javax.inject.Inject;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class UserMessageInboxDao {
    private DynamoDBMapper dynamoDBMapper;
    @Inject
    public UserMessageInboxDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }
    public List<UserMessageInbox> getUserMessagesInbox(String sendUaId) {
        return Collections.singletonList(dynamoDBMapper.load(UserMessageInbox.class, sendUaId));
    }

    public UserMessageInbox createInbox(UserMessageInbox newInbox) {

        dynamoDBMapper.save(newInbox);
        return newInbox;
    }
}
