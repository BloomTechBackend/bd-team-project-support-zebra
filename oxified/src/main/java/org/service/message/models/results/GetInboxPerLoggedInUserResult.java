package main.java.org.service.message.models.results;

import main.java.org.service.message.dynamodb.models.UserMessageInbox;

import java.util.List;

public class GetInboxPerLoggedInUserResult {
    private List<UserMessageInbox> inboxIds;
    private String uaid;

    public GetInboxPerLoggedInUserResult() {
    }

    public GetInboxPerLoggedInUserResult(List<UserMessageInbox> inboxIds, String uaid) {
        this.inboxIds = inboxIds;
        this.uaid = uaid;
    }

    public List<UserMessageInbox> getInboxIds() {
        return inboxIds;
    }

    public void setInboxIds(List<UserMessageInbox> inboxIds) {
        this.inboxIds = inboxIds;
    }

    public String getUaid() {
        return uaid;
    }

    public void setUaid(String uaid) {
        this.uaid = uaid;
    }

}
