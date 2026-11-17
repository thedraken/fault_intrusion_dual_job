package org.uni.lu.messages;

import org.joda.time.DateTime;

import java.security.MessageDigest;

public abstract class AbstractReplicaViewMessage extends AbstractViewMessage {
    protected final Long replicaId;

    public AbstractReplicaViewMessage(long messageId, DateTime dateTime, Long viewId, Long sequenceNumber, MessageDigest digest, Long replicaId) {
        super(messageId, dateTime, viewId, sequenceNumber, digest);
        this.replicaId = replicaId;
    }
}
