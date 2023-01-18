package main.java.org.service.message.models.results;

import com.oxified.message.service.models.MessageModel;

public class CreateMessageResult {
    private MessageModel messageModel;

    public CreateMessageResult(CreateMessageBuilder builder) {
        this.messageModel = builder.messageModel;
    }

    public static final class CreateMessageBuilder {
        private static MessageModel messageModel;
    public CreateMessageBuilder builder() {
        return new CreateMessageBuilder();
    }
        public CreateMessageBuilder() {
        }
        public CreateMessageBuilder withMessageModel(MessageModel messageModel) {
            this.messageModel = messageModel;
            return this;
        }
        public CreateMessageResult build() {
            return new CreateMessageResult(this);
        }

    }
}
