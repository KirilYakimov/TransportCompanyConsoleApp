package models;

import java.util.concurrent.atomic.AtomicInteger;

public class Client {
    private static AtomicInteger nextId = new AtomicInteger();
    private int clientID;
    private String nameOfClient;


    public Client(String nameOfClient){
        this.clientID = nextId.incrementAndGet();
        this.nameOfClient = nameOfClient;
    }

    public void setNameOfClient(String nameOfClient) {
        this.nameOfClient = nameOfClient;
    }

    public int getClientID() {
        return clientID;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientID = " + clientID +
                ", nameOfClient = '" + nameOfClient + '\'' +
                " }";
    }
}
