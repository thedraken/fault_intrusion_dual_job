package org.uni.lu.messages;

import java.security.MessageDigest;

public class CommitMessage extends AbstractReplicaViewMessage {

    public CommitMessage(long messageId, Long timeStamp, Long viewId, Long sequenceNumber, MessageDigest digest, Long replicaId) {
        super(messageId, timeStamp, viewId, sequenceNumber, digest, replicaId);
    }
}
