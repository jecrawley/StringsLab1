package crawley.james.driverslicense;

/**
 * Created by jamescrawley on 10/11/16.
 */
public class Main {

    public static void main(String[] args) {
        DriversLicense driversLicense = new DriversLicense("John Smith", 'M', "04-27-1983", 134.2, true, " ");
        System.out.println(DriversLicense.getCSVHeader());
        System.out.println(driversLicense.serializeToCSV());
        DriversLicense deserialized = DriversLicense.deserializeFromCSV(driversLicense.serializeToCSV());
        System.out.println(deserialized.serializeToCSV());
    }
}
