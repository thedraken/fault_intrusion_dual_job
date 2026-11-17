package org.uni.lu;

public class UIView {

    private final ClientRequest clientRequest;

    public UIView(ClientRequest clientRequest) {
        this.clientRequest = clientRequest;
    }

    public ClientRequest getClientRequest() {
        return clientRequest;
    }
}
