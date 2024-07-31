package com.travelcompany.eshop.services;

import com.travelcompany.eshop.model.Itinerary;
import java.util.List;
import java.util.ArrayList;


/*
 * ItineraryService class contains a list of Itinerary objects as well as methods
 * to get , add , update or delete an Itinerary object.
 * As initial data , we use the list "Itineraries" from the appendix.
 */
public class ItineraryService {

    private List<Itinerary> itineraries;
    
    public ItineraryService() {
        this.itineraries = initializeItineraries();
    }

    public List<Itinerary> getItineraries() {
        return itineraries;
    }

    public void printItineraries() {
        for (Itinerary itinerary : itineraries) {
            System.out.println(itinerary);
        }
    }

    private List<Itinerary> initializeItineraries() {
        List<Itinerary> itineraryList = new ArrayList<>();
        itineraryList.add(new Itinerary(1, "ATH", "PAR", "22/02/2022 13:35", "SkyLines", 300));
        itineraryList.add(new Itinerary(2, "ATH", "LON", "22/02/2022 13:40", "SkyLines", 420));
        itineraryList.add(new Itinerary(3, "ATH", "AMS", "22/02/2022 13:45", "SkyLines", 280));
        itineraryList.add(new Itinerary(4, "ATH", "PAR", "22/02/2022 14:20", "SkyLines", 310));
        itineraryList.add(new Itinerary(5, "ATH", "DUB", "22/02/2022 14:35", "SkyLines", 880));
        itineraryList.add(new Itinerary(6, "ATH", "FRA", "22/02/2022 14:55", "SkyLines", 380));
        itineraryList.add(new Itinerary(7, "ATH", "FRA", "22/02/2022 15:35", "SkyLines", 350));
        itineraryList.add(new Itinerary(8, "ATH", "MEX", "22/02/2022 16:00", "SkyLines", 1020));
        itineraryList.add(new Itinerary(9, "ATH", "DUB", "22/02/2022 16:35", "SkyLines", 770));
        return itineraryList;
    };

    
    public Itinerary getItineraryById(int id) {
        for (Itinerary itinerary : itineraries) {
            if (itinerary.getId() == id) {
                return itinerary;
            }
        }
        return null;
    }
    
    public void addItinerary(Itinerary itinerary) {

    }

    public void updateItinerary(Itinerary itinerary) {

    }

    public void deleteItinerary(Itinerary itinerary) {

    }

}
