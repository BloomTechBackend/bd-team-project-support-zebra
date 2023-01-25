package main.java.org.service.message.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.org.exceptions.InvalidAttributeValueException;
import main.java.org.service.message.dynamodb.models.UserMessage;
import main.java.org.service.message.models.request.CreateMessageRequest;
import main.java.org.service.message.models.results.CreateMessageResult;
import main.java.org.service.message.util.MessageUtils;
import main.java.org.service.spservice.dynamodb.ServiceDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class CreateMessageActivity implements RequestHandler<CreateMessageRequest, CreateMessageResult> {
    private Logger log = LogManager.getLogger();
    private ServiceDao serviceDao;

    @Inject
    public CreateMessageActivity(ServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }
    /**
     * Handles a Lambda Function request
     *
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return The Lambda Function output
     */
    @Override
    public CreateMessageResult handleRequest(CreateMessageRequest input, Context context) {
        log.info("Received CreateMessage Request {}", input);
        if(MessageUtils.isValid(input.getMessageId())) {
            throw new InvalidAttributeValueException();
        }
        UserMessage message = new UserMessage();
        message.setMessageBody(input.getMessageBody());
        message.setReceiverUaid(input.getReceiverUaid());
        message.setSenderUaid(input.getSenderUaid());

        return null;
    }
}
