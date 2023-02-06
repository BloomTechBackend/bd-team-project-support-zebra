package main.java.org.service.message.models.results;

import main.java.org.service.message.models.CreateMessageInboxModel;

public class CreateMessageInboxResult {
    CreateMessageInboxModel inboxModel;
    private String inboxId;
    private String messageBody;
    private String dateTime;
    private String senderUaid;
    private String receiverUaid;
    public CreateMessageInboxResult(CreateMessageInboxResultBuilder builder) {
        this.inboxModel = builder.inboxModel;
        this.inboxId = builder.inboxId;
        this.messageBody = builder.messageBody;
        this.dateTime = builder.dateTime;
        this.senderUaid = builder.senderUaid;
        this.receiverUaid = builder.receiverUaid;
    }

    public CreateMessageInboxModel getInboxModel() {
        return inboxModel;
    }

    public void setInboxModel(CreateMessageInboxModel inboxModel) {
        this.inboxModel = inboxModel;
    }

    public String getInboxId() {
        return inboxId;
    }

    public void setInboxId(String inboxId) {
        this.inboxId = inboxId;
    }
    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getSenderUaid() {
        return senderUaid;
    }

    public void setSenderUaid(String senderUaid) {
        this.senderUaid = senderUaid;
    }

    public String getReceiverUaid() {
        return receiverUaid;
    }

    public void setReceiverUaid(String receiverUaid) {
        this.receiverUaid = receiverUaid;
    }





    public static CreateMessageInboxResultBuilder builder() {
        return new CreateMessageInboxResultBuilder();
    }

    public final static class CreateMessageInboxResultBuilder {
        CreateMessageInboxModel inboxModel;
        private String inboxId;
        private String messageBody;
        private String dateTime;
        private String senderUaid;
        private String receiverUaid;
        public CreateMessageInboxResultBuilder() {
        }

        public CreateMessageInboxResultBuilder withInboxModel(CreateMessageInboxModel inboxModel) {
            this.inboxModel = inboxModel;
            return this;
        }

        public CreateMessageInboxResultBuilder withInboxId(String inboxId) {
            this.inboxId = inboxId;
            return this;
        }

        public CreateMessageInboxResultBuilder withMessageBody(String messageBody) {
            this.messageBody = messageBody;
            return this;
        }

        public CreateMessageInboxResultBuilder withDateTime(String dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public CreateMessageInboxResultBuilder withSenderUaid(String senderUaid) {
            this.senderUaid = senderUaid;
            return this;
        }

        public CreateMessageInboxResultBuilder withReceiverUaid(String receiverUaid) {
            this.receiverUaid = receiverUaid;
            return this;
        }

        public CreateMessageInboxResult build() {
            return new CreateMessageInboxResult(this);
        }
    }
}
