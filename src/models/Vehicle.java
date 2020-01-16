package models;

import enumClass.DriverVehicle_qualification;

public class Vehicle {
    private  int vehicleID = 0;
    private String vehicleName;
    private DriverVehicle_qualification vQua;

    public Vehicle(String vehicleName, DriverVehicle_qualification vQua){
        this.vehicleID++;
        this.vehicleName = vehicleName;
        this.vQua = vQua;

    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setvQua(DriverVehicle_qualification vQua) {
        this.vQua = vQua;
    }

    public DriverVehicle_qualification getvQua() {
        return vQua;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleID = " + vehicleID +
                ", vehicleName = '" + vehicleName + '\'' +
                ", vQua = " + vQua +
                " }";
    }
}
