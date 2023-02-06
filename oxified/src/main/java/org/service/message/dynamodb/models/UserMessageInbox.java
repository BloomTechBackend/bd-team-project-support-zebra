package main.java.org.service.message.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.UUID;
@DynamoDBTable(tableName = "inbox")
public class UserMessageInbox {

    private String inboxId;
    private String messageBody;
    private String dateTime;
    private String senderUaid;
    private String receiverUaid;

    public UserMessageInbox(UserMessage message) {
        messageBody = message.getMessageBody();
        senderUaid = message.getSenderUaid();
        receiverUaid = message.getReceiverUaid();
        dateTime = message.getDateTime();
    }

    @DynamoDBHashKey(attributeName = "id")
    public String getInboxId() {
        return inboxId;
    }

    public void setInboxId() {
        this.inboxId = UUID.randomUUID().toString();;
    }
    @DynamoDBAttribute(attributeName = "message")
    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
    @DynamoDBRangeKey(attributeName = "date_time")
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    @DynamoDBAttribute(attributeName = "sender_uaid")
    public String getSenderUaid() {
        return senderUaid;
    }

    public void setSenderUaid(String senderUaid) {
        this.senderUaid = senderUaid;
    }
    @DynamoDBAttribute(attributeName = "receiver_uaid")
    public String getReceiverUaid() {
        return receiverUaid;
    }

    public void setReceiverUaid(String receiverUaid) {
        this.receiverUaid = receiverUaid;
    }

}
