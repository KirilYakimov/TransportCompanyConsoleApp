package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Company {
    private String nameOfCompany;
    private String emailOfCompany;
    private String addressOfCompany;
    private static int numberOfContracts = 0;
    private static int numberOfClients = 0;
    private static int numberOfVehicle = 0;

    private HashSet<Client> clientList;
    private HashMap<Integer, Employee> employeeList;
    private HashSet<Vehicle> vehicleList;
    private HashMap<Integer ,TransportationData> transportationDataList;
    private HashMap<TransportationData, Employee> employeeTransportation;


    //Creates a Company
    public Company(String nameOfCompany, String emailOfCompany, String addressOfCompany){
        this.nameOfCompany = nameOfCompany;
        this.emailOfCompany = emailOfCompany;
        this.addressOfCompany = addressOfCompany;

        clientList = new HashSet<>();
        employeeList = new HashMap<>();
        vehicleList = new HashSet<>();
        transportationDataList = new HashMap<>();
        employeeTransportation = new HashMap<>();
    }

    //---------------Client------------------//

    // Add's the client
    public void addClient(Client client) {
        clientList.add(client);
        numberOfClients++;
    }

    // Removes the client
    public void removeClient(Client client) {
        if (clientList.contains(client)) {
            System.out.println("Client is removed from the list!");
            clientList.remove(client);
            numberOfClients--;
        } else {
            System.out.println("This client " + client + " is not in the list!");
        }
    }

    //--------------/Client------------------//

    //---------------Vehicle-----------------//

    // Add's vehicle
    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
        numberOfVehicle++;
    }

    // Removes vehicle
    public void removeVehicle(Vehicle vehicle) {
        if (vehicleList.contains(vehicle)) {
            System.out.println("Vehicle is removed from the list!");
            vehicleList.remove(vehicle);
            numberOfVehicle--;
        } else {
            System.out.println("This vehicle " + vehicle + " is not in the list!");
        }
    }

    //--------------/Vehicle-----------------//

    //--------------Employee-----------------//

    // Add's the employee
    public void addEmployee(Employee employee) {
        employeeList.put(employee.getEmployeeID(), employee);
        numberOfContracts++;
    }

    // Removes the employee
    public void removeEmployee(Employee employee) {
        if (employeeList.containsKey(employee.getEmployeeID())) {
            employeeList.remove(employee.getEmployeeID(), employee);
            --numberOfContracts;
            System.out.println("Employee is removed from the list!");
        } else {
            System.out.println("This employee " + employee + " is not in the list!");
        }
    }

    // Display Employees
    public void displayEmployeeList() {
        if (employeeList.isEmpty()) {
            System.out.println("There are no employees!");
        } else {
            employeeList.forEach(
                    (id, employee) -> System.out.println(id + " -> " + employee));
        }
    }

    //--------------/Employee-----------------//

    //------------/Transportation---------------//

    // Add's the transportation
    public void addTransportation(TransportationData transportationData){
        transportationDataList.put(transportationData.getTransportId() ,transportationData);
    }

    // Removes the transportation
    public void removeTransportation(TransportationData transportationData){
        transportationDataList.remove(transportationData.getTransportId() ,transportationData);
    }

    // Starts the transportation
    public void employeeTransport(Employee employee, TransportationData transportationData) {
        if (transportationData.isItPayed()){
            employeeTransportation.put(transportationData, employee);
            employee.setTotalPayment(employee.getTotalPayment() + transportationData.getFee());
        }else {
            System.out.println("That transportation fee needs to be payed before cargo is transported.");
        }
    }

    //------------/Transportation---------------//

    public void setNameOfCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    public void setEmailOfCompany(String emailOfCompany) {
        this.emailOfCompany = emailOfCompany;
    }

    public void setAddressOfCompany(String addressOfCompany) {
        this.addressOfCompany = addressOfCompany;
    }

    //---------------Data---------------//

    //-----Number-of-hired-employees----//
    public void getNumberOfContracts() {
        System.out.println("The number of all employee contracts:" + numberOfContracts);
    }

    //--------Number-of-clients--------//
    public void getNumberOfClients() {
        System.out.println("The number of all clients:" + numberOfClients);
    }

    // SetPayment
    public void setPaymentData(TransportationData transportationData, boolean paid){
        if (transportationDataList.containsKey(transportationData.getTransportId())){
            if (transportationData.isItPayed()){
                System.out.println("Client already payed: " + transportationData.getFee() + " for the transportation.");
            } else {
                DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDateTime now = LocalDateTime.now();
                System.out.println("Cargo: " + transportationData.getTransportId() + ", Date: " + date.format(now) + ", fee: " + transportationData.getFee() + ", Paid: " + paid);
                transportationData.setPayment(paid);
        }
        }else{
            System.out.println("Cargo is not in the data!");
        }
    }

    // GetPayment
    public void getPaymentData(TransportationData transportationData){
        if(!transportationData.isItPayed()){
            System.out.println("Client didn't payed yet.");
        } else {
            System.out.println("Client payed: " + transportationData.getFee() + " for the transportation.");
        }
    }

    public void getNumOftransportations(){
        System.out.println("Number of transportation's: " + employeeTransportation.size());
    }

    // Get total paid taxes
    public void getTotalPaidFees(){
        double[] sum = {0};
        employeeTransportation.forEach(
                (transportationData, employee) -> sum[0] += transportationData.getFee());
        System.out.println("Total paid fees: " + sum[0]);
    }

    // How many transportation did a given employee did
    public void employeesTransportation() {
        System.out.print("Employees transportation's: ");
        Map<Object,Long> employeesTransportations = employeeTransportation.values().stream()
                .collect(Collectors.groupingBy(Employee::getNameOfEmployee, Collectors.counting()));

        System.out.println(employeesTransportations);
    }

    //
    public void getEmployeeTotalPayment(){
        employeeList.forEach(
                (id, employee) -> System.out.println(id + " -> " + employee.getNameOfEmployee() + " - " + employee.getTotalPayment()));
    }

    @Override
    public String toString() {
        return "Company{ " +
                "nameOfCompany = '" + nameOfCompany + '\'' +
                ", emailOfCompany = '" + emailOfCompany + '\'' +
                ", addressOfCompany = '" + addressOfCompany + '\'' +
                " }";
    }
}