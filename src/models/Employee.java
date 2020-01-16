package models;

import enumClass.DriverVehicle_qualification;

import java.util.concurrent.atomic.AtomicInteger;

public class Employee{
    private static AtomicInteger nextId = new AtomicInteger();
    private final int employeeID;
    private String nameOfEmployee;
    private String addressOfEmployee;
    private String emailOfEmployee;
    private DriverVehicle_qualification driverQua;
    private double totalPayment;

    public Employee(String nameOfEmployee, String addressOfEmployee, String emailOfEmployee, DriverVehicle_qualification driverQua){
        this.employeeID = nextId.incrementAndGet();;
        this.nameOfEmployee = nameOfEmployee;
        this.addressOfEmployee = addressOfEmployee;
        this.emailOfEmployee = emailOfEmployee;
        this.driverQua = driverQua;
        this.totalPayment = 0;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setNameOfEmployee(String nameOfEmployee) {
        this.nameOfEmployee = nameOfEmployee;
    }

    public String getNameOfEmployee() {
        return nameOfEmployee;
    }

    public void setAddressOfEmployee(String addressOfEmployee) {
        this.addressOfEmployee = addressOfEmployee;
    }

    public String getAddressOfEmployee() {
        return addressOfEmployee;
    }

    public void setEmailOfEmployee(String emailOfEmployee) {
        this.emailOfEmployee = emailOfEmployee;
    }

    public String getEmailOfEmployee() {
        return emailOfEmployee;
    }

    public void setDriverQua(DriverVehicle_qualification driverQua) {
        this.driverQua = driverQua;
    }

    public DriverVehicle_qualification getDriverQua() {
        return driverQua;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    @Override
    public String toString() {
        return "Employee{ " +
                "nameOfEmployee= '" + nameOfEmployee + '\'' +
                ", addressOfEmployee= '" + addressOfEmployee + '\'' +
                ", emailOfEmployee= '" + emailOfEmployee + '\'' +
                ", driverQua= " + driverQua +
                " }";
    }
}
