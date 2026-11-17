package org.uni.lu.messages;

import org.joda.time.DateTime;

public class ReplyMessage extends AbstractMessage {

    private final Long clientId;
    private final Long replicaId;
    private final Integer result;

    public ReplyMessage(long messageId, DateTime dateTime, Long clientId, Long replicaId, Integer result) {
        super(messageId, dateTime);
        this.clientId = clientId;
        this.replicaId = replicaId;
        this.result = result;
    }
}
