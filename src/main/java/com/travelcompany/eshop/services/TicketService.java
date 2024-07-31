package com.travelcompany.eshop.services;

import com.travelcompany.eshop.model.PaymentMethodType;
import com.travelcompany.eshop.model.Ticket;
import java.util.ArrayList;
import java.util.List;


/*
 * TicketService class contains a list of Ticket objects as well as methods
 * to get , add , update or delete a Ticket object.
 * As initial data , we use the list "Ordered tickets" from the appendix.
 */
public class TicketService {

    private List<Ticket> tickets;

    public TicketService() {

        this.tickets = initializeTickets();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void printTickets() {

        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
    }

    private List<Ticket> initializeTickets() {
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(new Ticket(1, 1, 2, PaymentMethodType.CASH));
        ticketList.add(new Ticket(2, 2, 3, PaymentMethodType.CASH));
        ticketList.add(new Ticket(3, 3, 3, PaymentMethodType.CREDITCARD));
        ticketList.add(new Ticket(4, 2, 4, PaymentMethodType.CREDITCARD));
        ticketList.add(new Ticket(5, 3, 4, PaymentMethodType.CASH));
        ticketList.add(new Ticket(6, 4, 7, PaymentMethodType.CREDITCARD));
        ticketList.add(new Ticket(7, 5, 7, PaymentMethodType.CREDITCARD));
        ticketList.add(new Ticket(8, 2, 9, PaymentMethodType.CASH));
        ticketList.add(new Ticket(9, 1, 3, PaymentMethodType.CASH));

        return ticketList;

    }
    
    public void addTicket(Ticket ticket) {

    }

    public void updateTicket(Ticket ticket) {

    }

    public void deleteTicket(Ticket ticket) {

    }

}
