package com.travelcompany.eshop;

import com.travelcompany.eshop.services.DataService;

public class TravelCompanyApp {

    public static void main(String[] args) {

        DataService dataService = new DataService();
        dataService.run();

    }

}
