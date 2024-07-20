package com.travelcompany.eshop.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Itinerary {
    
    private int id;
    private String departure;
    private String destination;
    private Date departureDate;
    private String airlineName;
    private double basePrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public Itinerary(int id, String departure, String destination, String departureDate ,String airlineName, double basePrice) {
        this.id = id;
        this.departure = departure;
        this.destination = destination;
        this.departureDate = parseDate(departureDate);
        this.airlineName = airlineName;
        this.basePrice = basePrice;
    }
    
    private Date parseDate(String dateStr) {
            try {
                return new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
}
