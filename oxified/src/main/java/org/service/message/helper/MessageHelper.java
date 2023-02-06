package main.java.org.service.message.helper;

import main.java.org.service.message.dynamodb.models.UserMessage;

import java.time.ZonedDateTime;

public class MessageHelper {
    public static UserMessage generateMessage() {
        UserMessage message = new UserMessage();
        message.setSenderUaid("SenderId");
        message.setMessageBody("This is a message");
        message.setReceiverUaid("receiverId");
        message.setDateTime(ZonedDateTime.now().toString());
        return message;
    }
}
