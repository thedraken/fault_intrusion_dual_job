package org.uni.lu.messages;

import org.uni.lu.SenderType;

public class ReplyMessage extends AbstractViewMessage {

    private final Long clientId;
    private final Long replicaId;
    private final Integer result;

    public ReplyMessage(Long messageId, Long timeStamp, Long senderId, SenderType senderType, Long viewId, Long sequenceNumber, String digest, Long clientId, Long replicaId, Integer result) {
        super(messageId, timeStamp, senderId, senderType, viewId, sequenceNumber, digest);
        this.clientId = clientId;
        this.replicaId = replicaId;
        this.result = result;
    }

    public Long getClientId() {
        return clientId;
    }

    public Long getReplicaId() {
        return replicaId;
    }

    public Integer getResult() {
        return result;
    }
}
