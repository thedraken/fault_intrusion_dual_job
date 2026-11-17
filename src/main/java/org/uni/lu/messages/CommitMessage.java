package org.uni.lu.messages;

import org.joda.time.DateTime;
import org.uni.lu.UIView;

import java.security.MessageDigest;

public class CommitMessage extends AbstractReplicaViewMessage {

    public CommitMessage(long messageId, DateTime dateTime, UIView uiView, Long sequenceNumber, MessageDigest digest, Long replicaId) {
        super(messageId, dateTime, uiView, sequenceNumber, digest, replicaId);
    }
}
