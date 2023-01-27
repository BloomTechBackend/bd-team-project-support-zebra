package main.java.org.service.message.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.org.service.message.dynamodb.UserMessageDao;
import main.java.org.service.message.dynamodb.models.UserMessage;
import main.java.org.service.message.models.request.GetMessagePerInboxIdRequest;
import main.java.org.service.message.models.results.GetMessagePerInboxIdResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;

public class GetMessagesPerInboxIdActivity implements RequestHandler<GetMessagePerInboxIdRequest, GetMessagePerInboxIdResult> {
    private Logger log = LogManager.getLogger();
    private UserMessageDao messageDao;
    @Inject
    public GetMessagesPerInboxIdActivity(UserMessageDao messageDao) {
        this.messageDao = messageDao;
    }

    /**
     * Handles a Lambda Function request
     *
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return The Lambda Function output
     */
    @Override
    public GetMessagePerInboxIdResult handleRequest(GetMessagePerInboxIdRequest input, Context context) {
        log.info("Received GetMessagePerInboxIdRequest", input);
        List<UserMessage> messages = messageDao.getUserMessages(input.getInboxId());
        return new GetMessagePerInboxIdResult(messages);
    }
}
