package org.uni.lu.messages;

import org.joda.time.DateTime;
import org.uni.lu.Function;
import org.uni.lu.devices.Client;

public class ClientRequestMessage extends AbstractMessage {
    private final DateTime dateTime;
    private final Function function;

    public ClientRequestMessage(Client client, DateTime dateTime, Function function) {
        super(client.getId(), dateTime);
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
