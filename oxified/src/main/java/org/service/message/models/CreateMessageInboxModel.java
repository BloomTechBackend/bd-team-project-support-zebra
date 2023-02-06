package main.java.org.service.message.models;

import java.time.ZonedDateTime;
import java.util.Objects;

public class CreateMessageInboxModel {
    //private String inboxId;
    private String messageBody;
    private String dateTime;
    private String senderUaid;
    private String receiverUaid;

    public CreateMessageInboxModel() {
    }

    public CreateMessageInboxModel(MessageInboxModelBuilder builder) {
        //inboxId = builder.inboxId;
        messageBody = builder.messageBody;
        dateTime = builder.dateTime;
        senderUaid = builder.senderUaid;
        receiverUaid = builder.receiverUaid;
    }


//    public String getInboxId() {
//        return inboxId;
//    }
//
//    public void setInboxId(String inboxId) {
//        this.inboxId = inboxId;
//    }

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
    public static MessageInboxModelBuilder builder() {
        return new MessageInboxModelBuilder();
    }
    public static class MessageInboxModelBuilder {
        private String inboxId;
        private String messageBody;
        private String dateTime;
        private String senderUaid;
        private String receiverUaid;
        public MessageInboxModelBuilder() {

        }


        public MessageInboxModelBuilder withInboxId(String inboxId) {
            this.inboxId = inboxId;
            return this;
        }


        public MessageInboxModelBuilder withMessageBody(String messageBody) {
            this.messageBody = messageBody;
            return this;
        }
        public MessageInboxModelBuilder withDateTime(String dateTime) {
            this.dateTime = dateTime;
            return this;
        }
        public MessageInboxModelBuilder withSenderUaid(String senderUaid) {
            this.senderUaid = senderUaid;
            return this;
        }
        public MessageInboxModelBuilder withReceiverUaid(String receiverUaid) {
            this.receiverUaid = receiverUaid;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (! ( o instanceof MessageInboxModelBuilder )) return false;
            MessageInboxModelBuilder that = (MessageInboxModelBuilder) o;
            return Objects.equals(inboxId, that.inboxId) && Objects.equals(dateTime, that.dateTime) && Objects.equals(senderUaid, that.senderUaid) && Objects.equals(receiverUaid, that.receiverUaid);
        }

        @Override
        public int hashCode() {
            return Objects.hash(inboxId, dateTime, senderUaid, receiverUaid);
        }

        public CreateMessageInboxModel build() {
            return new CreateMessageInboxModel(this);
        }
    }
}
