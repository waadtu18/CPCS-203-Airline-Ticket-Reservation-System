package P2_EasyRent;
// Waad Turki Alharbi
// IAR 
// CPCS203

public class Flight {

    private String flighNo;
    private String departure;
    private String destination;
    private double fare;

    //--------------------------CONSRUCTER---------------------------------
    public Flight(String flighNo, String departure, String destination, double fare) {
        this.flighNo = flighNo;
        this.departure = departure;
        this.destination = destination;
        this.fare = fare;
    }

    //-------------------------GETTERS-------------------------------------
    public String getFlighNo() {
        return flighNo;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public double getFare() {
        return fare;
    }

    //------------------------SETTERS--------------------------------------
    public void setFlighNo(String flighNo) {
        this.flighNo = flighNo;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    //--------------------------SERVICE METHODS---------------------------
    public String toString() {
        return "Flight No.: " + flighNo + " Departure: " + departure + "	Destination: " + destination + "	Fare: SAR " + fare + "\n ------------------- \n";

    }

}
