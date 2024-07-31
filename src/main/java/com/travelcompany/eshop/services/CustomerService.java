package com.travelcompany.eshop.services;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.CustomerType;
import java.util.ArrayList;
import java.util.List;


/*
 * CustomerService class contains a list of Customer objects as well as methods
 * to get , add , update or delete a Customer object.
 * As initial data , we use the list "Customers" from the appendix.
 */
public class CustomerService {

    private List<Customer> customers;

    public CustomerService() {

        this.customers = initializeCustomers();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    private List<Customer> initializeCustomers() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(1, "Maria Iordanou", "miordanou@mail.com", "Athens", "Greek", CustomerType.INDIVIDUAL));
        customerList.add(new Customer(2, "Dimitriou Dimitrios", "ddimitriou@mail.com", "Athens", "Greek", CustomerType.INDIVIDUAL));
        customerList.add(new Customer(3, "Ioannis Ioannou", "iioannou@mail.com", "Athens", "Greek", CustomerType.BUSINESS));
        customerList.add(new Customer(4, "Antonio Molinari", "amolinari@mail.com", "Milan", "Italian", CustomerType.INDIVIDUAL));
        customerList.add(new Customer(5, "Frederico Rossi", "frossi@mail.com", "Milan", "Italian", CustomerType.INDIVIDUAL));
        customerList.add(new Customer(6, "Mario Conti", "mconti@mail.com", "Rome", "Italian", CustomerType.BUSINESS));
        customerList.add(new Customer(7, "Nathan Martin", "nmartin@mail.com", "Lyon", "French", CustomerType.BUSINESS));
        customerList.add(new Customer(8, "Enzo Collin", "ecollin@mail.com", "Lyon", "French", CustomerType.INDIVIDUAL));
        customerList.add(new Customer(9, "Frederic Michel", "fmichel@mail.com", "Athens", "French", CustomerType.INDIVIDUAL));
        return customerList;
    }

    public Customer getCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }

        }
        return null;
    }

    public void addCustomer(Customer customer) {

    }

    public void updateCustomer(Customer customer) {

    }

    public void deleteCustomer(Customer customer) {

    }

}
