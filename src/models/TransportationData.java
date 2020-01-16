package models;

import enumClass.TypeOfCargo;

import java.util.concurrent.atomic.AtomicInteger;

public class TransportationData {
    private static AtomicInteger nextId = new AtomicInteger();
    private final int clientId;
    private Client clientName;
    private double fee;
    private boolean payment;
    private String startPoint;
    private String endPoint;
    private TypeOfCargo typeOfCargo;
    private double weightOfCargo;

    public TransportationData(TypeOfCargo typeOfCargo, Client clientName, double fee, boolean payment, String startPoint, String endPoint){
        this.clientId = nextId.incrementAndGet();
        this.clientName = clientName;
        this.fee = fee;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.typeOfCargo = typeOfCargo;
        this.weightOfCargo = 0;
        this.payment = payment;
    }

    public TransportationData(TypeOfCargo typeOfCargo, Client clientName, double fee, boolean payment, String startPoint, String endPoint, double weightOfCargo){
        this.clientId = nextId.incrementAndGet();
        this.clientName = clientName;
        this.fee = fee;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.typeOfCargo = typeOfCargo;
        this.weightOfCargo = weightOfCargo;
        this.payment = payment;
    }

    public int getClientId() {
        return clientId;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getFee() {
        return fee;
    }

    public void setWeightOfCargo(double weightOfCargo) {
        this.weightOfCargo = weightOfCargo;
    }

    public double getWeightOfCargo() {
        return weightOfCargo;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public TypeOfCargo getTypeOfCargo() {
        return typeOfCargo;
    }

    public Client getClientName() {
        return clientName;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    public boolean isItPayed() {
        return payment;
    }

    @Override
    public String toString() {
        return "ShippingData{" +
                ", clientName = " + clientName +
                ", payed = " + payment +
                ", fee = " + fee +
                ", startPoint = '" + startPoint + '\'' +
                ", endPoint = '" + endPoint + '\'' +
                ", typeOfCargo = " + typeOfCargo +
                ", weightOfCargo = " + weightOfCargo +
                '}';
    }
}
