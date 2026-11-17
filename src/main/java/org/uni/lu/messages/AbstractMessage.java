package org.uni.lu.messages;


import org.uni.lu.SenderType;

public abstract class AbstractMessage {

    private final Long messageId;
    /**
     * A counter that increases to show the passage of time
     */
    private final Long timeStamp;
    private Long senderId;
    private SenderType senderType;

    public AbstractMessage(Long messageId, Long timeStamp) {
        this.messageId = messageId;
        this.timeStamp = timeStamp;
    }

    public long getMessageId() {
        return messageId;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public Long getSenderId() {
        return senderId;
    }

    /**
     * Assumption only the network can set this in this test, normally each sender would sign their request?
     *
     * @param senderId The ID of the device sending the message, should normally be done via signature so you can prove which device sent it
     */
    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public SenderType getSenderType() {
        return senderType;
    }

    /**
     * Assumption only the network can set this, normally set by each sender with a signature to confirm it came from them
     *
     * @param senderType The type of device sending this message
     */
    public void setSenderType(SenderType senderType) {
        this.senderType = senderType;
    }
}
