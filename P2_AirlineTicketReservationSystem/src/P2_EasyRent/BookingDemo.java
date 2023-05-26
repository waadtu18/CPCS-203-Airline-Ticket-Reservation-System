package P2_EasyRent;
// Waad Turki Alharbi
// IAR 
// CPCS203

import java.io.*;

import java.util.*;

public class BookingDemo {

    public static void main(String[] args) throws Exception {

        //======================Creating Files==================================
        File inputDBFile = new File("inputDB.txt");
        File inputBookingFile = new File("inputBookings.txt");
        File outputBookingFile = new File("printBookings.txt");
        File outputLogFile = new File("printLog.txt");

        //=================Checking the existence of Files======================
        if (!inputDBFile.exists()) {
            System.out.println("File " + inputDBFile.getName() + " does not exists!");
            System.exit(0);
        }

        if (!inputBookingFile.exists()) {
            System.out.println("File " + inputBookingFile.getName() + " does not exists!");
            System.exit(0);
        }

        //===============Creating Scanners and PrintWriters Objects=============
        Scanner inputDB = new Scanner(inputDBFile);
        Scanner inputB = new Scanner(inputBookingFile);
        PrintWriter outputB = new PrintWriter(outputBookingFile);
        PrintWriter outputDB = new PrintWriter(outputLogFile);

        //===============Getting the length of the arrays from file DB==========
        int totalAirlines = inputDB.nextInt();
        int totalAirports = inputDB.nextInt();
        int totalFlights = inputDB.nextInt();

        //===============Creating the Arrays====================================
        Flight[] listFlight = new Flight[totalFlights];
        Airline[] listAirline = new Airline[totalAirlines];
        Airport[] listAirport = new Airport[totalAirports];

        //================Printing in DB File===================================
        outputDB.println("--------------- Air Ticket Reservation System Log ---------------");
        outputDB.println();
        outputDB.println();

        //================Declaring and Initalizing Variables===================
        String command;
        int i, j, k;
        i = j = k = -1;

        //==================Loop to Fill the Arrays=============================
        while (true) {

            command = inputDB.next();

            if (command.matches("ADD_Airline")) {

                i++;

                listAirline[i] = getAirline(inputDB);

            } else if (command.equals("ADD_Airport")) {

                j++;

                listAirport[j] = getAirport(inputDB);

            } else if (command.equals("ADD_Flight")) {

                k++;

                listFlight[k] = getFlight(inputDB);

            } else if (command.equals("Quit")) {
                //==================Loops to Print in printLog File=============
                for (int a = 0; a < listAirline.length; a++) {
                    outputDB.println("(New Airline Added)	" + listAirline[a].toString());
                }
                for (int a = 0; a < listFlight.length; a++) {
                    outputDB.println("(New Flight Added)	" + listFlight[a].toString());
                }
                for (int a = 0; a < listAirport.length; a++) {
                    outputDB.println("(New Airport Added)	" + listAirport[a].toString());
                }
                break;
            }

        }
        //=========================Closing All DB Files=========================
        outputDB.flush();
        outputDB.close();
        inputDB.close();

        //=========================Printing in Booking File=====================
        outputB.println("--------------- Welcome to Air Ticket Reservation System ---------------");
        outputB.println();
        outputB.println();

        //========================Creating Booking Array========================
        int totalBookings = inputB.nextInt();
        Booking[] listBooking = new Booking[totalBookings];

        //==================Declaring and initalizing Variables=================
        String commandB;
            int w = -1;

        //==================Loop to Fill the Array==============================
        while (true) {
            commandB = inputB.next();
            if (commandB.matches("NewBooking")) {
                w++;
                listBooking[w] = GenerateBooking(inputB, listFlight, listAirline, listAirport, outputB);
            } else if (commandB.equals("Quit")) {
                break;
            }

        }

        //=========================Closing Booking File=========================
        outputB.flush();
        inputB.close();
        outputB.close();
        //=========Creating Arrays to Find Number of Flights Peer Airport========
        Airport allairports[] = listAirport;
        Booking alltickets[] = listBooking;
        NumOfFlightspeerAirport(allairports, alltickets, outputB);

    }

    //--------------------------SERVICE METHODS---------------------------
    private static Flight getFlight(Scanner inputDB) {

        String flighNo = inputDB.next();
        String departure = inputDB.next();
        String destination = inputDB.next();
        double fare = inputDB.nextDouble();

        return new Flight(flighNo, departure, destination, fare);

    }

    //--------------------------------------------------------------------------
    private static Airline getAirline(Scanner inputDB) {
        String twoDigitCode = inputDB.next();
        String name = inputDB.next();
        String originCountry = inputDB.next();
        String website = inputDB.next();
        return new Airline(twoDigitCode, name, originCountry, website);
    }

    //--------------------------------------------------------------------------
    private static Airport getAirport(Scanner inputDB) {
        String threeDigitCode = inputDB.next();
        String city = inputDB.next();
        String name = inputDB.next();

        return new Airport(threeDigitCode, city, name);
    }

    //--------------------------------------------------------------------------
    private static Flight searchFlight(Scanner input, Flight[] listFlight) {
        String f = input.next();
        Flight f2 = null;
        for (int i = 0; i < listFlight.length; i++) {
            if (f.equals(listFlight[i].getFlighNo())) {
                return listFlight[i];
            }
        }
        return f2;
    }

    //--------------------------------------------------------------------------
    private static Airline searchAirline(Scanner input, Airline[] listAirline) {
        String f = input.next();
        Airline f2 = null;
        for (int i = 0; i < listAirline.length; i++) {
            if (f.equals(listAirline[i].getTwoDigitCode())) {
                return listAirline[i];
            }
        }
        return f2;
    }

    //--------------------------------------------------------------------------
    private static Airport searchAirport(Scanner input, Airport[] listAirport) {
        String f = input.next();
        Airport f2 = null;
        for (int i = 0; i < listAirport.length; i++) {
            if (f.equals(listAirport[i].getThreeDigitCode())) {
                return listAirport[i];
            }
        }
        return f2;
    }
   
    //--------------------------------------------------------------------------
    private static Booking GenerateBooking(Scanner input, Flight[] listFlight, Airline[] listAirline, Airport[] listAirport, PrintWriter fWrite) {

        long bookingNo = System.currentTimeMillis();

        Flight flight = searchFlight(input, listFlight);

        Airline airline = searchAirline(input, listAirline);

        Airport airport = searchAirport(input, listAirport);

        int year = input.nextInt();
        int month = input.nextInt();
        int day = input.nextInt();
        Date flightDate = new Date(year , month , day);
        String name = input.next();

        int yearb = input.nextInt();
        int monthb = input.nextInt();
        int dayb = input.nextInt();
        Date dob = new Date(yearb, monthb, dayb);

        Boolean isBusinessClass = input.nextBoolean();

        int baggageWeight = input.nextInt();

        Booking tempBooking = new Booking(bookingNo, flight, airline, airport, flightDate, name, dob, isBusinessClass, baggageWeight);

        PrintBooking(tempBooking, fWrite);

        return tempBooking;

    }
   
    //--------------------------------------------------------------------------
    public static void PrintBooking(Booking tempBooking, PrintWriter fWrite) {
        Date dob = tempBooking.getDob();
        fWrite.println("Booking No. " + tempBooking.getBookingNo());
        fWrite.println();
        fWrite.println("Passenger Details	Passenger Name: " + tempBooking.getName() + "		Date of Birth: " + dob.getYear() + "-" + dob.getDate() + "-" + dob.getMonth());
        fWrite.println();

        Date d = tempBooking.getFlightDate();
        Airline al = tempBooking.getAirline();
        Flight f = tempBooking.getFlight();
        Airport ap = tempBooking.getAirport();
        fWrite.println("Flight Details	Flight Code: " + al.getTwoDigitCode() + "-" + f.getFlighNo() + "			" + d.getYear() + "-" + d.getDate() + "-" + d.getMonth());
        fWrite.println("		Departure: " + f.getDeparture() + "			Destination: " + f.getDestination());
        fWrite.println();
        fWrite.println("Airport Details	Airport Name: " + ap.getName() + " (" + ap.getThreeDigitCode() + "), " + ap.getCity());
        fWrite.println();
        fWrite.println("Airline Details	Name: " + al.getName() + " based in " + al.getWebsite());
        fWrite.println();
        fWrite.println("Fare Details	Regular Fare: SAR " + f.getFare());
        fWrite.printf("		Total Fare: SAR %.1f %n", tempBooking.CalculateFare());
        fWrite.println("â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€");

    }
   
    //--------------------------------------------------------------------------
    public static void NumOfFlightspeerAirport(Airport[] allairports, Booking[] alltickets, PrintWriter fWrite) {

        int total;
        for (int i = 0; i < allairports.length; i++) {
            total = 0;
            for (int j = 0; j < alltickets.length; j++) {
                if ((allairports[i].getThreeDigitCode()).equalsIgnoreCase(alltickets[j].getAirport().getThreeDigitCode())) {
                    total++;
                }
            }
        }

    }

}
