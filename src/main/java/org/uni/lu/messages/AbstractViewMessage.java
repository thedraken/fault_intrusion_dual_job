package org.uni.lu.messages;

import org.joda.time.DateTime;

import java.security.MessageDigest;

public abstract class AbstractViewMessage extends AbstractMessage {

    private final Long viewId;
    private final Long sequenceNumber;
    private final MessageDigest digest;

    public AbstractViewMessage(long messageId, DateTime dateTime, Long viewId, Long sequenceNumber, MessageDigest digest) {
        super(messageId, dateTime);
        this.viewId = viewId;
        this.sequenceNumber = sequenceNumber;
        this.digest = digest;
    }
}
