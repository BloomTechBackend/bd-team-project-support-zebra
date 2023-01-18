package main.java.org.service.message.converter;

import com.oxified.message.service.dynamodb.models.Message;
import com.oxified.message.service.models.MessageModel;

public class ModelConverter {
    public MessageModel toMessageModel(Message message) {
        return MessageModel.builder()
                .withInboxId(message.getInboxId())
                .withMessageBody(message.getMessageBody())
                .withSenderUaid(message.getSenderUaid())
                .withDateTime(message.getDateTime())
                .withReceiverUaid(message.getReceiverUaid())
                .withMessageId(message.getMessageId())
                .build();
    }
}
