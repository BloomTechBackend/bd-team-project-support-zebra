package main.java.org.service.message.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.org.service.message.dynamodb.UserMessageInboxDao;
import main.java.org.service.message.dynamodb.models.UserMessageInbox;
import main.java.org.service.message.models.request.GetInboxPerLoggedInUserRequest;
import main.java.org.service.message.models.results.GetInboxPerLoggedInUserResult;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.inject.Inject;
import java.util.List;

public class GetInboxPerLoggedInUserActivity  implements RequestHandler<GetInboxPerLoggedInUserRequest, GetInboxPerLoggedInUserResult> {
    private Logger log = LogManager.getLogger();
    private UserMessageInboxDao messageInboxDao;
@Inject
    public GetInboxPerLoggedInUserActivity(UserMessageInboxDao messageInboxDao) {
        this.messageInboxDao = messageInboxDao;
    }

    /**
     * Handles a Lambda Function request
     *
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return The Lambda Function output
     */
    @Override
    public GetInboxPerLoggedInUserResult handleRequest(GetInboxPerLoggedInUserRequest input, Context context) {
        log.info("Received GetInboxPerloggedInUser {}", input);
        List<UserMessageInbox> userInbox = messageInboxDao.getUserMessagesInbox(input.getUaId());
        return new GetInboxPerLoggedInUserResult(userInbox,input.getUaId() );
    }
}
