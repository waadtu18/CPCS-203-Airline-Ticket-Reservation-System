package P2_EasyRent;
// Waad Turki Alharbi
// IAR 
// CPCS203

public class Airport {

    private String threeDigitCode;
    private String city;
    private String name;

    //--------------------------CONSRUCTER---------------------------------
    public Airport(String threeDigitCode, String city, String name) {
        this.threeDigitCode = threeDigitCode;
        this.city = city;
        this.name = name;
    }

    //-------------------------GETTERS-------------------------------------
    public String getThreeDigitCode() {
        return threeDigitCode;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    //------------------------SETTERS--------------------------------------
    public void setThreeDigitCode(String threeDigitCode) {
        this.threeDigitCode = threeDigitCode;

    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    //--------------------------SERVICE METHODS---------------------------
    public String toString() {
        return "Airport Code: " + threeDigitCode + "	City: " + city + "\tName: " + name + "\n ------------------- \n";
    }

}
