package com.oxified.message.service.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.oxified.message.service.converter.MessageLinkListConverter;

import java.util.List;

public class MessageInbox {

    private String inboxId;
    private String messageBody;
    private String dateTime;
    private String senderUaid;
    private String receiverUaid;

    private List<Message> messages;

    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    public String getInboxId() {
        return inboxId;
    }

    public void setInboxId(String inboxId) {
        this.inboxId = inboxId;
    }
    @DynamoDBAttribute
    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
    @DynamoDBRangeKey(attributeName = "date_time")
    @DynamoDBAutoGeneratedTimestamp
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

    @DynamoDBTypeConverted(converter = MessageLinkListConverter.class)
    public List<Message> getMessages() {
        return messages;
    }
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}

