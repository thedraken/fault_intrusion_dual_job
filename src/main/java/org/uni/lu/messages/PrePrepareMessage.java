package org.uni.lu.messages;

import java.security.MessageDigest;

public class PrePrepareMessage extends AbstractViewMessage {

    private final ClientRequestMessage requestMessage;

    public PrePrepareMessage(long messageId, Long timeStamp, Long viewId, Long sequenceNumber, MessageDigest digest, ClientRequestMessage requestMessage) {
        super(messageId, timeStamp, viewId, sequenceNumber, digest);
        this.requestMessage = requestMessage;
    }
}
