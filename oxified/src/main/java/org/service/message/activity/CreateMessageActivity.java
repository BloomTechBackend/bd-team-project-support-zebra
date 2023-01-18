package main.java.org.service.message.activity;


public class CreateMessageActivity implements RequestHandler<CreateMessageRequest, CreateMessageResult>{
    private final Logger log = LogManager.getLogger();
    private final MessageDAO messageDAO;
    private final MessageInboxDAO messageInboxDAO;


    public CreateMessageActivity(MessageDAO messageDAO, MessageInboxDAO messageInboxDAO) {
        this.messageDAO = messageDAO;
        this.messageInboxDAO = messageInboxDAO;
    }

    /**
     * Handles a Lambda Function request
     *
     * @param createMessageRequest   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return The Lambda Function output
     */
    @Override
    public CreateMessageResult handleRequest(CreateMessageRequest createMessageRequest, Context context) {
        log.info("Received CreateMessageRequest {}", createMessageRequest );
        Message createdMessage = new Message();
        createdMessage = messageDAO.saveMessage(createdMessage);

        MessageModel messageModel = new ModelConverter().toMessageModel(createdMessage);

        return new CreateMessageResult.CreateMessageBuilder()
                .withMessageModel(messageModel)
                .build();
    }
}
