package main.java.org.service.message.models;

import com.oxified.message.service.dynamodb.models.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageInboxModel {
    private String inboxId;
    private List<Message> messages = new ArrayList<>();
}
