package org.uni.lu.messages;

import org.joda.time.DateTime;

import java.security.MessageDigest;

public class PrePrepareMessage extends AbstractViewMessage {

    private final ClientRequestMessage requestMessage;

    public PrePrepareMessage(long messageId, DateTime dateTime, Long viewId, Long sequenceNumber, MessageDigest digest, ClientRequestMessage requestMessage) {
        super(messageId, dateTime, viewId, sequenceNumber, digest);
        this.requestMessage = requestMessage;
    }
}
