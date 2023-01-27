package main.java.org.service.message.models.request;

public class GetInboxPerLoggedInUserRequest {
    private String InboxId;
    private String uaId;

    public GetInboxPerLoggedInUserRequest() {
    }

    public String getInboxId() {
        return InboxId;
    }

    public void setInboxId(String inboxId) {
        InboxId = inboxId;
    }

    public String getUaId() {
        return uaId;
    }

    public void setUaId(String uaId) {
        this.uaId = uaId;
    }


}
