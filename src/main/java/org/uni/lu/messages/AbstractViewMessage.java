package org.uni.lu.messages;

import org.uni.lu.SenderType;

public abstract class AbstractViewMessage extends AbstractMessage {

    private final Long viewId;
    private final Long sequenceNumber;
    private final String digest;

    public AbstractViewMessage(Long messageId, Long timeStamp, Long senderId, SenderType senderType, Long viewId, Long sequenceNumber, String digest) {
        super(messageId, timeStamp, senderId, senderType);
        this.viewId = viewId;
        this.sequenceNumber = sequenceNumber;
        this.digest = digest;
    }

    public Long getViewId() {
        return viewId;
    }

    public Long getSequenceNumber() {
        return sequenceNumber;
    }

    public String getDigest() {
        return digest;
    }
}
