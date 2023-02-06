package main.java.org.service.message.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.org.service.message.converter.MessageInboxConverter;
import main.java.org.service.message.dynamodb.UserMessageInboxDao;
import main.java.org.service.message.dynamodb.models.UserMessage;
import main.java.org.service.message.dynamodb.models.UserMessageInbox;
import main.java.org.service.message.helper.MessageHelper;
import main.java.org.service.message.models.CreateMessageInboxModel;
import main.java.org.service.message.models.request.CreateMessageInboxRequest;
import main.java.org.service.message.models.results.CreateMessageInboxResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.time.ZonedDateTime;

public class CreateMessageInboxIdActivity implements RequestHandler<CreateMessageInboxRequest, CreateMessageInboxResult> {
    private Logger log = LogManager.getLogger();
    private UserMessageInboxDao inboxDao;
    @Inject
    public CreateMessageInboxIdActivity(UserMessageInboxDao inboxDao) {
        this.inboxDao = inboxDao;
    }

    /**
     * Handles a Lambda Function request
     *
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return The Lambda Function output
     */
    @Override
    public CreateMessageInboxResult handleRequest(CreateMessageInboxRequest input, Context context) {

        UserMessage message = MessageHelper.generateMessage();

        input = new CreateMessageInboxRequest(message);

        UserMessageInbox inbox = new UserMessageInbox(message);
        inbox.setInboxId();
        inbox.setDateTime(input.getDateTime());
        inbox.setMessageBody(input.getMessageBody());
        inbox.setSenderUaid(input.getSenderUaid());
        inbox.setReceiverUaid(input.getReceiverUaid());
        CreateMessageInboxModel inboxModel = MessageInboxConverter.toMessageInboxModel(inboxDao.createInbox(inbox));
        return CreateMessageInboxResult.builder()
                .withInboxModel(inboxModel)
                .build();
    }
}
