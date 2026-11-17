package org.uni.lu.messages;


import org.uni.lu.SenderType;

public abstract class AbstractMessage {

    private final Long messageId;
    /**
     * A counter that increases to show the passage of time
     */
    private final Long timeStamp;
    private final Long senderId;
    private final SenderType senderType;

    public AbstractMessage(Long messageId, Long timeStamp, Long senderId, SenderType senderType) {
        this.messageId = messageId;
        this.timeStamp = timeStamp;
        this.senderId = senderId;
        this.senderType = senderType;
    }

    public long getMessageId() {
        return messageId;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    /***
     * A sender ID, another node cannot forge another's sender ID, as it's assumed to be signed by the sender. This is a prototype
     * @return Returns the sender's ID
     */
    public Long getSenderId() {
        return senderId;
    }

    public SenderType getSenderType() {
        return senderType;
    }
}
