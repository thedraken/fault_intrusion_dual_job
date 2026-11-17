package org.uni.lu.messages;

import org.joda.time.DateTime;

import java.security.MessageDigest;

public class CommitMessage extends AbstractReplicaViewMessage {

    public CommitMessage(long messageId, DateTime dateTime, Long viewId, Long sequenceNumber, MessageDigest digest, Long replicaId) {
        super(messageId, dateTime, viewId, sequenceNumber, digest, replicaId);
    }
}
