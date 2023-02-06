package main.java.org.service.message.models.results;

import com.amazonaws.services.s3.internal.eventstreaming.Message;
import main.java.org.service.message.models.CreateMessageInboxModel;

import java.util.List;

public class GetMessagePerInboxIdResult {
    CreateMessageInboxModel messageInboxModel;
    List<Message> messages;

    public GetMessagePerInboxIdResult() {
    }

    public CreateMessageInboxModel getMessageInboxModel() {
        return messageInboxModel;
    }

    public void setMessageInboxModel(CreateMessageInboxModel messageInboxModel) {
        this.messageInboxModel = messageInboxModel;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
