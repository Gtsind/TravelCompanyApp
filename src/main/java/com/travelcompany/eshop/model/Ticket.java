package com.travelcompany.eshop.model;

public class Ticket {

    private int id;
    private int passengerId;
    private int itineraryId;
    private PaymentMethodType paymentMethod;
    private double paymentAmount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(int itineraryId) {
        this.itineraryId = itineraryId;
    }

    public PaymentMethodType getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodType paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Ticket(int id, int passengerId, int itineraryId, PaymentMethodType paymentMethod, double paymentAmount) {
        this.id = id;
        this.passengerId = passengerId;
        this.itineraryId = itineraryId;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
    }

}
