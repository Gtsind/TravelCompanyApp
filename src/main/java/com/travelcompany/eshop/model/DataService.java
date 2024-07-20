package com.travelcompany.eshop.model;

public class DataService {

    Customer[] customers = {};
    Itinerary[] itineraries = {};
    Ticket[] tickets = {};

    public void run() {

        initDummyData();
    }

    private Customer[] initializeCustomers() {
        Customer[] customers = new Customer[]{
            new Customer(1, "Maria Iordanou", "miordanou@mail.com", "Athens", "Greek", CustomerType.INDIVIDUAL),
            new Customer(2, "Dimitriou Dimitrios", "ddimitriou@mail.com", "Athens", "Greek", CustomerType.INDIVIDUAL),
            new Customer(3, "Ioannis Ioannou", "iioannou@mail.com", "Athens", "Greek", CustomerType.BUSINESS),
            new Customer(4, "Antonio Molinari", "amolinari@mail.com", "Milan", "Italian", CustomerType.INDIVIDUAL),
            new Customer(5, "Frederico Rossi", "frossi@mail.com", "Milan", "Italian", CustomerType.INDIVIDUAL),
            new Customer(6, "Mario Conti", "mconti@mail.com", "Rome", "Italian", CustomerType.BUSINESS),
            new Customer(7, "Nathan Martin", "nmartin@mail.com", "Lyon", "French", CustomerType.BUSINESS),
            new Customer(8, "Enzo Collin", "ecollin@mail.com", "Lyon", "French", CustomerType.INDIVIDUAL),
            new Customer(9, "Frederic Michel", "fmichel@mail.com", "Athens", "French", CustomerType.INDIVIDUAL)
        };

        return customers;
    }

    private Itinerary[] initializeItineraries() {
        Itinerary[] itineraries = new Itinerary[]{
            new Itinerary(1, "ATH", "PAR", "22/02/2022 13:35", "SkyLines", 300),
            new Itinerary(2, "ATH", "LON", "22/02/2022 13:40", "SkyLines", 420),
            new Itinerary(3, "ATH", "AMS", "22/02/2022 13:45", "SkyLines", 280),
            new Itinerary(4, "ATH", "PAR", "22/02/2022 14:20", "SkyLines", 310),
            new Itinerary(5, "ATH", "DUB", "22/02/2022 14:35", "SkyLines", 880),
            new Itinerary(6, "ATH", "FRA", "22/02/2022 14:55", "SkyLines", 380),
            new Itinerary(7, "ATH", "FRA", "22/02/2022 15:35", "SkyLines", 350),
            new Itinerary(8, "ATH", "MEX", "22/02/2022 16:00", "SkyLines", 1020),
            new Itinerary(9, "ATH", "DUB", "22/02/2022 16:35", "SkyLines", 770)
        };
        return itineraries;
    }

    private Ticket[] initializeTickets() {
        return new Ticket[]{
            new Ticket(1, 1, 2, PaymentMethodType.CASH, 462),
            new Ticket(2, 2, 3, PaymentMethodType.CASH, 308),
            new Ticket(3, 3, 3, PaymentMethodType.CREDITCARD, 224),
            new Ticket(4, 2, 4, PaymentMethodType.CREDITCARD, 341),
            new Ticket(5, 3, 4, PaymentMethodType.CASH, 248),
            new Ticket(6, 4, 7, PaymentMethodType.CREDITCARD, 968),
            new Ticket(7, 5, 7, PaymentMethodType.CREDITCARD, 968),
            new Ticket(8, 2, 10, PaymentMethodType.CASH, 1122),
            new Ticket(9, 1, 3, PaymentMethodType.CASH, 308)
        };
    }

    private void initDummyData() {
        this.customers = initializeCustomers();
        this.itineraries = initializeItineraries();
        this.tickets = initializeTickets();
        System.out.println(this.tickets.length);

    }
}
