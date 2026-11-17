package org.uni.lu.messages;

import java.security.MessageDigest;

public abstract class AbstractViewMessage extends AbstractMessage {

    private final Long viewId;
    private final Long sequenceNumber;
    private final MessageDigest digest;

    public AbstractViewMessage(Long messageId, Long timeStamp, Long viewId, Long sequenceNumber, MessageDigest digest) {
        super(messageId, timeStamp);
        this.viewId = viewId;
        this.sequenceNumber = sequenceNumber;
        this.digest = digest;
    }
}
