package org.uni.lu.messages;

import java.security.MessageDigest;

public abstract class AbstractReplicaViewMessage extends AbstractViewMessage {
    protected final Long replicaId;

    public AbstractReplicaViewMessage(long messageId, Long timeStamp, Long viewId, Long sequenceNumber, MessageDigest digest, Long replicaId) {
        super(messageId, timeStamp, viewId, sequenceNumber, digest);
        this.replicaId = replicaId;
    }
}
