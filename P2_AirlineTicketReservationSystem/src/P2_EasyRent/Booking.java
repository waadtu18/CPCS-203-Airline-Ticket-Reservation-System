package P2_EasyRent;
// Waad Turki Alharbi
// IAR 
// CPCS203

import java.util.*;

public class Booking {

    private long bookingNo;
    private Flight flight;
    private Airline airline;
    private Airport airport;
    Date flightDate;
    private String name;
    Date dob;
    private Boolean isBusinessClass;
    private int baggageWeight;

    //--------------------------CONSRUCTER---------------------------------
    public Booking(long bookingNo, Flight flight, Airline airline, Airport airport, Date flightDate, String name, Date dob, Boolean isBusinessClass, int baggageWeight) {
        this.bookingNo = bookingNo;
        this.flight = flight;
        this.airline = airline;
        this.airport = airport;
        this.flightDate = flightDate;
        this.name = name;
        this.dob = dob;
        this.isBusinessClass = isBusinessClass;
        this.baggageWeight = baggageWeight;

    }
    
    //-------------------------GETTERS-------------------------------------
    public long getBookingNo() {
        return bookingNo;
    }

    public Flight getFlight() {
        return flight;
    }

    public Airline getAirline() {
        return airline;
    }

    public Airport getAirport() {
        return airport;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {

        return dob;
    }

    public Boolean getBusinessClass() {
        return isBusinessClass;
    }

    public int getBaggageWeight() {
        return baggageWeight;
    }

    //------------------------SETTERS--------------------------------------
    public void setBookingNo(long bookingNo) {
        this.bookingNo = bookingNo;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setIsBusinessClass(Boolean isBusinessClass) {
        this.isBusinessClass = isBusinessClass;
    }

    public void setBaggageWeight(int baggageWeight) {
        this.baggageWeight = baggageWeight;
    }

    //--------------------------SERVICE METHODS---------------------------
    public double CalculateFare() {

        double regular = flight.getFare(); 
        double excessBaggage = 0;

        int currentDate = new Date().getYear() + 1900;
        int dofb = dob.getYear();
        
        int age = currentDate - dofb;
        if (age <= 12 && age > 2) {
            regular *= 0.7;
        }
        if (age <= 2) {
            regular *= 0.1;
        }

        if (isBusinessClass) {
            regular *= 1.4;
        }

        if (isBusinessClass && (baggageWeight > 50)) {
            excessBaggage = (baggageWeight - 50) * 30;
        }
        if (!(isBusinessClass) && (baggageWeight > 30)) {
            excessBaggage = (baggageWeight - 30) * 30;
        }

        return excessBaggage + regular;

    }

}
