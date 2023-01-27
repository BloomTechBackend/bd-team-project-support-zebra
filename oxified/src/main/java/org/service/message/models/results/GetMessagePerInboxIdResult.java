package main.java.org.service.message.models.results;

import main.java.org.service.message.dynamodb.models.UserMessage;

import java.util.List;

public class GetMessagePerInboxIdResult {

    private List<UserMessage> Messages;

    public GetMessagePerInboxIdResult() {
    }

    public GetMessagePerInboxIdResult( List<UserMessage> messages) {
        Messages = messages;
    }




    public List<UserMessage> getMessages() {
        return Messages;
    }

    public void setMessages(List<UserMessage> messages) {
        Messages = messages;
    }
}
