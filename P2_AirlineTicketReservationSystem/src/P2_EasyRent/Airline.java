package P2_EasyRent;
// Waad Turki Alharbi
// IAR 
// CPCS203

public class Airline {

    private String twoDigitCode;
    private String name;
    private String originCountry;
    private String website;

    //--------------------------CONSRUCTER---------------------------------
    public Airline(String twoDigitCode, String name, String originCountry, String website) {
        this.twoDigitCode = twoDigitCode;
        this.name = name;
        this.originCountry = originCountry;
        this.website = website;

    }

    //-------------------------GETTERS-------------------------------------
    public String getTwoDigitCode() {
        return twoDigitCode;
    }

    public String getName() {
        return name;
    }

    public String getoriginCountry() {
        return originCountry;
    }

    public String getWebsite() {
        return website;
    }

    //------------------------SETTERS--------------------------------------
    public void setTwoDigitCode(String twoDigitCode) {
        this.twoDigitCode = twoDigitCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    //--------------------------SERVICE METHODS---------------------------
    public String toString() {
        return "Airline No.: " + twoDigitCode + " Airline: " + name + "	Hub: " + originCountry + "	URL: " + website + "\n ------------------- \n";

    }
}
