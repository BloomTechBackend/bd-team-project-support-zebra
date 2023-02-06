package main.java.org.service.message.converter;

import main.java.org.service.message.dynamodb.models.UserMessageInbox;
import main.java.org.service.message.models.CreateMessageInboxModel;

public class MessageInboxConverter {
    public static CreateMessageInboxModel toMessageInboxModel(UserMessageInbox messageInbox) {
        return CreateMessageInboxModel.builder()
                .withDateTime(messageInbox.getDateTime())
                .withMessageBody(messageInbox.getMessageBody())
                .withReceiverUaid(messageInbox.getReceiverUaid())
                .withSenderUaid(messageInbox.getSenderUaid())
                .build();
    }
}
