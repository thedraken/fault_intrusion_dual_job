package org.uni.lu.messages;

import org.joda.time.DateTime;

import java.security.MessageDigest;

public class PrepareMessage extends AbstractReplicaViewMessage {

    public PrepareMessage(long messageId, DateTime dateTime, Long viewId, Long sequenceNumber, MessageDigest digest, Long replicaId) {
        super(messageId, dateTime, viewId, sequenceNumber, digest, replicaId);
    }
}
