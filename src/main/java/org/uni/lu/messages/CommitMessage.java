package org.uni.lu.messages;

import org.uni.lu.SenderType;

public class CommitMessage extends AbstractReplicaViewMessage {

    public CommitMessage(Long messageId, Long timeStamp, Long senderId, SenderType senderType, Long viewId, Long sequenceNumber, String digest, Long replicaId) {
        super(messageId, timeStamp, senderId, senderType, viewId, sequenceNumber, digest, replicaId);
    }
}
