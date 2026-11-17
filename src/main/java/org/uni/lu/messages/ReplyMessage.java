package org.uni.lu.messages;

import org.joda.time.DateTime;
import org.uni.lu.UIView;

public class ReplyMessage extends AbstractMessage {

    private final UIView view;
    private final Long clientId;
    private final Long replicaId;
    private final Integer result;

    public ReplyMessage(long messageId, DateTime dateTime, UIView view, Long clientId, Long replicaId, Integer result) {
        super(messageId, dateTime);
        this.view = view;
        this.clientId = clientId;
        this.replicaId = replicaId;
        this.result = result;
    }
}
