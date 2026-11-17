package org.uni.lu.messages;

import org.joda.time.DateTime;
import org.uni.lu.Function;

public class RequestMessage extends AbstractMessage {

    private final Function function;

    public RequestMessage(long messageId, DateTime dateTime, Function function) {
        super(messageId, dateTime);
        this.function = function;
    }
}
