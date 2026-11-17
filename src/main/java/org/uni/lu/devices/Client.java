package org.uni.lu.devices;

import org.uni.lu.AbstractSender;
import org.uni.lu.SenderType;

public class Client extends AbstractSender {

    public Client(Long id) {
        super(id, SenderType.CLIENT);
    }
}
