package main.java.org.service.message.models.results.requests;

import java.util.Objects;

public class CreateMessageRequest {
    private String messageId;
    private String messageBody;
    private String dateTime;
    private String senderUaid;
    private String receiverUaid;

    public CreateMessageRequest() {
    }

    public CreateMessageRequest(CreateMessageBuilder builder) {
        this.messageBody = builder.messageBody;
        this.dateTime = builder.dateTime;
        this.senderUaid = builder.senderUaid;
        this.receiverUaid = builder.receiverUaid;
    }
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! ( o instanceof CreateMessageRequest )) return false;
        CreateMessageRequest that = (CreateMessageRequest) o;
        return getMessageId().equals(that.getMessageId()) && getMessageBody().equals(that.getMessageBody()) && getDateTime().equals(that.getDateTime()) && getSenderUaid().equals(that.getSenderUaid()) && getReceiverUaid().equals(that.getReceiverUaid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMessageId(), getMessageBody(), getDateTime(), getSenderUaid(), getReceiverUaid());
    }

    public static class CreateMessageBuilder {
        private String messageBody;
        private String dateTime;
        private String senderUaid;
        private String receiverUaid;
        public CreateMessageBuilder() {
        }

        public CreateMessageBuilder withMessageBody(String messageBody) {
            this.messageBody = messageBody;
            return this;
        }

        public CreateMessageBuilder withDateTime(String dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public CreateMessageBuilder withSenderUaid(String senderUaid) {
            this.senderUaid = senderUaid;
            return this;
        }

        public CreateMessageBuilder withReceiverUaid(String receiverUaid) {
            this.receiverUaid = receiverUaid;
            return this;
        }

        public CreateMessageRequest build () {
            return new CreateMessageRequest(this);
        }

    }

}
