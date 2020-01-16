package app;

import enumClass.DriverVehicle_qualification;
import enumClass.TypeOfCargo;
import models.*;

public class Main {

    public static void main(String[] args) {
        //----------------Task.1----------------//
        Company transportCompany = new Company(
                "Transport Company OOD",
                "transport@gmail.com",
                "No physical address");

        //System.out.println(transportCompany);

        // Change company name
        transportCompany.setNameOfCompany("TransExpress");
        // Change company email
        transportCompany.setEmailOfCompany("Trans-Express@gmail.com");
        // Change company address
        transportCompany.setAddressOfCompany("Prince Alexander Dondukov Blvd.");

        //System.out.println(transportCompany);
        //---------------/Task.1----------------//

        //----------------Task.2----------------//
        Client client1 = new Client("client1");
        Client client2 = new Client("client2");
        Client client3 = new Client("client3");
        Client client4 = new Client("client4");

        // Add's client
        transportCompany.addClient(client1);
        transportCompany.addClient(client2);
        transportCompany.addClient(client3);
        transportCompany.addClient(client4);

        // Change client name
        client1.setNameOfClient("client9");
        // removes client
        transportCompany.removeClient(client3);

        //---------------/Task.2----------------//

        //----------------Task.3----------------//
        Vehicle vehicle1 = new Vehicle("Scania", DriverVehicle_qualification.CE);
        Vehicle vehicle2 = new Vehicle("Scania", DriverVehicle_qualification.CE);
        Vehicle vehicle3 = new Vehicle("Scania", DriverVehicle_qualification.C);
        Vehicle vehicle4 = new Vehicle("Mercedes", DriverVehicle_qualification.D);

        // Add's vehicle
        transportCompany.addVehicle(vehicle1);
        transportCompany.addVehicle(vehicle2);
        transportCompany.addVehicle(vehicle3);
        transportCompany.addVehicle(vehicle4);

        // Update vehicle
        vehicle2.setVehicleName("MAN");

        // Remove vehicle
        transportCompany.removeVehicle(vehicle1);

        //---------------/Task.3----------------//

        //----------------Task.4----------------//


        Employee filip = new Employee(
                "Filip",
                "Sofia",
                "Filip@gmail.com",
                DriverVehicle_qualification.D);

        Employee maria = new Employee("Maria","Sandanski","maria@gmail.com", DriverVehicle_qualification.CE);
        Employee pesho = new Employee("Pesho","NewYork","pesho@gmail.com", DriverVehicle_qualification.C);
        Employee elena = new Employee("Elena","London","elena@gmail.com", DriverVehicle_qualification.C);

        // Add's employee
        transportCompany.addEmployee(elena);
        transportCompany.addEmployee(filip);
        transportCompany.addEmployee(maria);
        transportCompany.addEmployee(pesho);


        // Remove employee
        transportCompany.removeEmployee(maria);

        transportCompany.displayEmployeeList();

        //---------------/Task.4----------------//

        //----------------Task.5----------------//

        TransportationData tData1 = new TransportationData(
                TypeOfCargo.CONTAINER_CARGO,
                client2,
                3000.5,
                false,
                "Sofia",
                "Moscow",
                10000);
        TransportationData tData2 = new TransportationData(TypeOfCargo.CONTAINER_CARGO,  client2, 3000.5,false,"Sofia","Moscow", 18000);
        TransportationData tData3 = new TransportationData(TypeOfCargo.PASSENGER_CARGO,  client1, 5000.90,false,"Sofia","Paris");
        TransportationData tData4 = new TransportationData(TypeOfCargo.PASSENGER_CARGO,  client4, 1000.0,true,"Sofia","Varna");



        // Add Transport data
        transportCompany.addTransportation(tData1);
        transportCompany.addTransportation(tData2);
        transportCompany.addTransportation(tData3);
        transportCompany.addTransportation(tData4);

        // Remove Transport data
        transportCompany.removeTransportation(tData2);









        //---------------/Task.5----------------//

        //----------------Task.6----------------//
        transportCompany.setPaymentData(tData1);

        transportCompany.employeeTransport(pesho, tData1);
        transportCompany.employeeTransport(filip, tData3);
        transportCompany.employeeTransport(filip, tData4);

        transportCompany.getPaymentData(tData1);
        transportCompany.getPaymentData(tData3);
        transportCompany.getPaymentData(tData4);

        //---------------/Task.6----------------//

        //----------------Task.7----------------//

        transportCompany.employeesTransportation();
        transportCompany.getEmployeeTotalPayment();

        //---------------/Task.7----------------//

        //----------------Task.1----------------//
        //delete company
        //----------------Task.1----------------//
    }
}
