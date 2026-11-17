package org.uni.lu.messages;

import org.uni.lu.Function;
import org.uni.lu.SenderType;
import org.uni.lu.devices.Client;

public class ClientRequestMessage extends AbstractMessage {
    private final Long clientId;
    private final Function function;

    public ClientRequestMessage(Long messageId, Long timeStamp, Long senderId, SenderType senderType, Client client, Function function) {
        super(messageId, timeStamp, senderId, senderType);
        this.clientId = client.getId();
        this.function = function;
    }

    public Function getFunction() {
        return function;
    }

    public byte[] canonicalBytes() {
        String s = clientId + "|" + getTimeStamp() + "|" + function.canonical();
        return s.getBytes(java.nio.charset.StandardCharsets.UTF_8);
    }
}
