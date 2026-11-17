package org.uni.lu.messages;

import org.uni.lu.Function;
import org.uni.lu.devices.Client;

public class ClientRequestMessage extends AbstractMessage {
    private final Function function;

    public ClientRequestMessage(Client client, Long timeStamp, Function function) {
        super(client.getId(), timeStamp);
        this.function = function;
    }

    public Function getFunction() {
        return function;
    }

}
