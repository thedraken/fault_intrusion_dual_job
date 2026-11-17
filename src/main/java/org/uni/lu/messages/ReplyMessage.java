package org.uni.lu.messages;

import java.security.MessageDigest;

public class ReplyMessage extends AbstractViewMessage {

    private final Long clientId;
    private final Long replicaId;
    private final Integer result;

    public ReplyMessage(Long messageId, Long timeStamp, Long viewId, Long sequenceNumber, MessageDigest digest, Long clientId, Long replicaId, Integer result) {
        super(messageId, timeStamp, viewId, sequenceNumber, digest);
        this.clientId = clientId;
        this.replicaId = replicaId;
        this.result = result;
    }
}
