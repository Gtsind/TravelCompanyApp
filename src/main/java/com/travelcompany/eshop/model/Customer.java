package com.travelcompany.eshop.model;

public class Customer {

    private int id;
    private String name;
    private String email;
    private String address;
    private String nationality;
    private CustomerType customerType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Customer(int id, String name, String email, String address, String nationality, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.nationality = nationality;
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", nationality=" + nationality + ", category=" + customerType + '}';
    }

}
