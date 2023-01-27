package main.java.org.service.message.models.request;

import main.java.org.service.message.dynamodb.models.UserMessage;

import java.util.List;

public class GetMessagePerInboxIdRequest {
    private List<UserMessage> messages;
    private String inboxId;

    public GetMessagePerInboxIdRequest(List<UserMessage> messages, String inboxId) {
        this.messages = messages;
        this.inboxId = inboxId;
    }

    public List<UserMessage> getMessages() {
        return messages;
    }

    public String getInboxId() {
        return inboxId;
    }
}
