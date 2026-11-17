package org.uni.lu.messages;

import java.security.MessageDigest;

public class PrepareMessage extends AbstractReplicaViewMessage {

    public PrepareMessage(long messageId, Long timeStamp, Long viewId, Long sequenceNumber, MessageDigest digest, Long replicaId) {
        super(messageId, timeStamp, viewId, sequenceNumber, digest, replicaId);
    }
}
