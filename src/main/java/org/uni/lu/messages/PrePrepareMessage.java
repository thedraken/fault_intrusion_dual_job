package org.uni.lu.messages;

import org.uni.lu.SenderType;

public class PrePrepareMessage extends AbstractViewMessage {

    private final ClientRequestMessage requestMessage;

    public PrePrepareMessage(Long messageId, Long timeStamp, Long senderId, SenderType senderType, Long viewId, Long sequenceNumber, String digest, ClientRequestMessage requestMessage) {
        super(messageId, timeStamp, senderId, senderType, viewId, sequenceNumber, digest);
        this.requestMessage = requestMessage;
    }

    public ClientRequestMessage getRequestMessage() {
        return requestMessage;
    }
}
