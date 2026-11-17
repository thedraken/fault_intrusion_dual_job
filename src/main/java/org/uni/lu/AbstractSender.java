package org.uni.lu;

import java.util.Objects;

public abstract class AbstractSender {

    private final Long id;
    private final SenderType senderType;

    public AbstractSender(Long id, SenderType senderType) {
        this.id = id;
        this.senderType = senderType;
    }

    public Long getId() {
        return id;
    }

    public SenderType getSenderType() {
        return senderType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AbstractSender that = (AbstractSender) o;
        return Objects.equals(getId(), that.getId()) && getSenderType() == that.getSenderType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSenderType());
    }
}
