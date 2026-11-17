package org.uni.lu.messages;

import org.joda.time.DateTime;
import org.uni.lu.UIView;

import java.security.MessageDigest;

public class PrePrepareMessage extends AbstractViewMessage {

    private final RequestMessage requestMessage;

    public PrePrepareMessage(long messageId, DateTime dateTime, UIView uiView, Long sequenceNumber, MessageDigest digest, RequestMessage requestMessage) {
        super(messageId, dateTime, uiView, sequenceNumber, digest);
        this.requestMessage = requestMessage;
    }
}
