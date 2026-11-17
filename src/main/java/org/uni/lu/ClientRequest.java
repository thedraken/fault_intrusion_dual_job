package org.uni.lu;

import org.joda.time.DateTime;

public class ClientRequest extends AbstractSender {
    private final DateTime dateTime;
    private final Function function;

    public ClientRequest(Long clientId, DateTime dateTime, Function function) {
        super(clientId, SenderType.CLIENT);
        this.dateTime = dateTime;
        this.function = function;
    }

    public Function getFunction() {
        return function;
    }

    public DateTime getDateTime() {
        return dateTime;
    }
}
