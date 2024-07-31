package com.travelcompany.eshop.services;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.CustomerType;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.PaymentMethodType;
import com.travelcompany.eshop.model.Ticket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * DataService class is the core of our program. Main points :
 *
 * It coordinates and manages the interaction between our service classes (CustomerService, ItineraryService, TicketService).
 * Its constructor initializes instances of our 3 service classes.
 * DataService contains business logic for processing data and generating reports.
 * Its method run() provides a command-line-interaction for its users.
 */
public class DataService {

    CustomerService customerService;
    ItineraryService itineraryService;
    TicketService ticketService;

    public DataService() {
        this.customerService = new CustomerService();
        this.itineraryService = new ItineraryService();
        this.ticketService = new TicketService();
    }

    public void run() {
        System.out.println("Booting, please wait...");
        calculateDiscounts();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to TravelCompany e-shop!");
            System.out.println("Please select an option :");
            System.out.println("Press 1. to get a list of total number and cost of tickets for all customers.");
            System.out.println("Press 2. to get a list of the total offered itineraries per destination and offered itineraries per departure.");
            System.out.println("Press 3. to get a list of the customers with the most tickets and with the largest cost of purchases.");
            System.out.println("Press 4. to get a list of the customers who have not purchased any tickets.");
            System.out.println("Press 5. to Exit");

            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    printCustomerReports();
                    System.out.println("\n");
                    break;
                case 2:
                    printItineraryReports();
                    System.out.println("\n");
                    break;
                case 3:
                    mostTicketsLargestCostCustomer();
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.println("Customers with no tickets :");
                    getCustomersWithNoTickets().forEach((customer) -> {
                        System.out.println(customer.getName());
                    });
                    System.out.println("\n");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Incorrect input...Please try again.");
            }
        }

    }

    private void calculateDiscounts() {
        System.out.println("Preparing data...");

        /*
         * FOREACH ORDERED TICKET IN TICKETSERVICE
         * > GET PASSENGER (CUSTOMERTYPE)
         * > GET ITINERARY (BASEPRICE)
         * > PAYMENT METHOD
         *
         * >> IS IT BUSINESS CUSTOMER? 
         * >> IS IT iNDIVIDUAL CUSTOMER?
         * 
         * >> IS IT CREDIT CARD
         * >> IS IT CASH
         * CALCULATE AND SET FINALPRICE TO EACH ORDERED TICKET
         */
        ticketService.getTickets().forEach((ticket) -> {

            Customer customer = customerService.getCustomerById(ticket.getPassengerId());
            Itinerary itinerary = itineraryService.getItineraryById(ticket.getItineraryId());
            PaymentMethodType method = ticket.getPaymentMethod();
            double discount = 1;

            // discount rules
            discount += customerTypeDiscount(customer.getCustomerType());
            discount += paymentMethodDiscount(method);

            //calculate and set final price for each ticket
            double finalPrice = itinerary.getBasePrice() * discount;
            ticket.setPaymentAmount(finalPrice);

        });

    }
    
    //rules for calculateDiscounts()

    private double customerTypeDiscount(CustomerType customerType) {
        if (customerType == CustomerType.BUSINESS) {
            return -0.1;
        }
        if (customerType == CustomerType.INDIVIDUAL) {
            return 0.2;
        }
        return 0;
    }

    private double paymentMethodDiscount(PaymentMethodType method) {

        if (method == PaymentMethodType.CREDITCARD) {
            return -0.1;
        }

        return 0;
    }

    // reporting
    // List of customers who have not purchased any tickets
    private List<Customer> getCustomersWithNoTickets() {
        /*
         * get all passenger Ids from ordered tickets 
         * filter out these ids from customer list
         * return remaining customer list
         */

        List<Integer> passengerIds = ticketService.getTickets().stream().map((ticket)
                -> ticket.getPassengerId()).toList();
        List<Customer> noTicketCustomers = customerService.getCustomers().stream().filter((customer)
                -> {
            return !passengerIds.contains(customer.getId());
        }).toList();

        return noTicketCustomers;
    }

    //List of total number and total cost of tickets for each customer
    private void printCustomerReports() {
        /*
         * create a map from ordered tickets list to store total number of tickets purchased by each customer
         * create a map from ordered tickets list to store total cost of tickets purchased by each customer
         * this method iterates through all tickets ,updating the counts and costs for each customer.
         * print results
         */
        Map<Integer, Integer> ticketCountMap = new HashMap<>();
        Map<Integer, Double> ticketCostMap = new HashMap<>();

        for (Ticket ticket : ticketService.getTickets()) {
            int customerId = ticket.getPassengerId();
            double ticketCost = ticket.getPaymentAmount();

            ticketCountMap.put(customerId, ticketCountMap.getOrDefault(customerId, 0) + 1);
            ticketCostMap.put(customerId, ticketCostMap.getOrDefault(customerId, 0.0) + ticketCost);
        }

        //print results for number of tickets per customer
        System.out.println("Total number of tickets purchased by each customer:");
        ticketCountMap.forEach((customerId, count) -> {

            Customer customer = customerService.getCustomerById(customerId);
            if (customer != null) {
                if (count == 1) {
                    System.out.println(customer.getName() + " has purchased " + count + " ticket");
                } else if (count != 1) {
                    System.out.println(customer.getName() + " has purchased " + count + " tickets");
                }
            }

        });

        System.out.println("\n");

        //print results for cost of tickets per customer
        System.out.println("Total cost of tickets purchased by each customer:");
        ticketCostMap.forEach((customerId, cost) -> {

            Customer customer = customerService.getCustomerById(customerId);
            if (customer != null) {
                System.out.println(customer.getName() + " : " + cost);
            }

        });

    }

    //List of the customers with the most tickets and with the largest cost of purchases
    private void mostTicketsLargestCostCustomer() {

        Map<Integer, Integer> ticketCountMap = new HashMap<>();
        Map<Integer, Double> ticketCostMap = new HashMap<>();

        for (Ticket ticket : ticketService.getTickets()) {
            int customerId = ticket.getPassengerId();
            double ticketCost = ticket.getPaymentAmount();

            ticketCountMap.put(customerId, ticketCountMap.getOrDefault(customerId, 0) + 1);
            ticketCostMap.put(customerId, ticketCostMap.getOrDefault(customerId, 0.0) + ticketCost);
        }

        //find customer with most tickets
        int maxTicketsCustomerId = 0;
        int maxTickets = 0;
        for (Map.Entry<Integer, Integer> entry : ticketCountMap.entrySet()) {
            if (entry.getValue() > maxTickets) {
                maxTickets = entry.getValue();
                maxTicketsCustomerId = entry.getKey();
            }
        }

        //find customer with largest total cost
        int maxCostCustomerId = 0;
        double maxTotalCost = 0.0;
        for (Map.Entry<Integer, Double> entry : ticketCostMap.entrySet()) {
            if (entry.getValue() > maxTotalCost) {
                maxTotalCost = entry.getValue();
                maxCostCustomerId = entry.getKey();
            }
        }
        //print results for customer with the most tickets
        System.out.println("Customer with the most tickets :");
        Customer maxTicketCustomer = customerService.getCustomerById(maxTicketsCustomerId);
        System.out.println("The customer with the most tickets is " + maxTicketCustomer.getName() + ". They bought " + maxTickets + " tickets.");

        System.out.println("\n");

        //print results for customer with the largest cost of purchases
        System.out.println("Customer with the largest cost of purchases :");
        Customer maxCostCustomer = customerService.getCustomerById(maxCostCustomerId);
        System.out.println("The customer with the largest cost of purchases is " + maxCostCustomer.getName() + ". Total cost is : " + maxTotalCost);
    }

    //List of total offered itineraries per destination and offered itineraries per departure
    private void printItineraryReports() {

        /*
         * create a map from itineraries list to store the count of itineraries for each destination
         * create a map from itineraries list to store the count of itineraries for each departure
         * this method iterates through all itineraries and updates the count for each destination/departure
         * print results
         */
        Map<String, Integer> destinationCountMap = new HashMap<>();
        Map<String, Integer> departureCountMap = new HashMap<>();

        for (Itinerary itinerary : itineraryService.getItineraries()) {
            String destination = itinerary.getDestination();
            String departure = itinerary.getDeparture();

            destinationCountMap.put(destination, destinationCountMap.getOrDefault(destination, 0) + 1);
            departureCountMap.put(departure, departureCountMap.getOrDefault(departure, 0) + 1);
        }

        System.out.println("Total offered itineraries per destination:");
        destinationCountMap.forEach((destination, count)
                -> System.out.println("Destination " + destination + ", " + "Available itineraries: " + count)
        );

        System.out.println("\n");

        System.out.println("Total offered itineraries per departure:");
        departureCountMap.forEach((departure, count)
                -> System.out.println("Departure " + departure + ", " + "Available itineraries: " + count)
        );

    }

}
