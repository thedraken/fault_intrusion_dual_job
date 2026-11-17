package org.uni.lu.messages;

import org.uni.lu.SenderType;

public abstract class AbstractReplicaViewMessage extends AbstractViewMessage {
    protected final Long replicaId;

    public AbstractReplicaViewMessage(Long messageId, Long timeStamp, Long senderId, SenderType senderType, Long viewId, Long sequenceNumber, String digest, Long replicaId) {
        super(messageId, timeStamp, senderId, senderType, viewId, sequenceNumber, digest);
        this.replicaId = replicaId;
    }

    public Long getReplicaId() {
        return replicaId;
    }
}
