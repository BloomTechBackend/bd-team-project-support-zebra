package main.java.org.service.message.models.results;

import main.java.org.service.message.models.CreateMessageInboxModel;

public class GetInboxPerLoggedInUserResult {
    CreateMessageInboxModel messageInboxModel;

    public GetInboxPerLoggedInUserResult() {
    }

    public CreateMessageInboxModel getMessageInboxModel() {
        return messageInboxModel;
    }

    public void setMessageInboxModel(CreateMessageInboxModel messageInboxModel) {
        this.messageInboxModel = messageInboxModel;
    }
}
