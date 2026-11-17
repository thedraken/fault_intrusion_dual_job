package org.uni.lu.messages;

import org.joda.time.DateTime;
import org.uni.lu.UIView;

import java.security.MessageDigest;

public abstract class AbstractViewMessage extends AbstractMessage {

    private final UIView uiView;
    private final Long sequenceNumber;
    private final MessageDigest digest;

    public AbstractViewMessage(long messageId, DateTime dateTime, UIView uiView, Long sequenceNumber, MessageDigest digest) {
        super(messageId, dateTime);
        this.uiView = uiView;
        this.sequenceNumber = sequenceNumber;
        this.digest = digest;
    }
}
