package crawley.james.driverslicense;

import java.util.Arrays;

/**
 * Created by jamescrawley on 10/11/16.
 */
public class DriversLicense {

    private String dateOfBirth;
    private char gender;
    private String name;
    private String endorsements;
    private double weight;
    private boolean organDonor;


    public DriversLicense (String name, char gender, String dateOfBirth, double weight, boolean organDonor, String endorsements) {

        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.organDonor = organDonor;
        this.endorsements = endorsements;

    }

    @Override
    public boolean equals(Object in) {

        boolean isEqual = false;
        DriversLicense compared = (DriversLicense) in;

        if (this.name.equals(compared.name) && this.gender == compared.gender && this.dateOfBirth.equals(compared.dateOfBirth) && this.weight == compared.weight && this.organDonor == compared.organDonor && this.endorsements.equals(compared.endorsements))
            isEqual = true;

        return isEqual;
    }

    String serializeToCSV () {

        return String.format ("%s,%c,%s,%.2f,%b,%s", name, gender, dateOfBirth, weight, organDonor, endorsements);

    }

    String serializeToJSON () {

        return String.format("{\"name\":\"%s\", \"gender\":\"%c\", \"dateOfBirth\":\"%s\", \"weight\":%.2f, \"organDonor\":%b, \"endorsements\":\"%s\"}", name, gender, dateOfBirth, weight, organDonor, endorsements);

    }

    static String getCSVHeader () {

        return String.format ("%s,%s,%s,%s,%s,%s", "Name", "Gender", "Date of Birth", "Weight", "Organ Donor", "Endorsements");

    }

    static DriversLicense deserializeFromCSV (String serializedLicense) {

        String[] arr = serializedLicense.split(",");

        return new DriversLicense(arr[0], arr[1].charAt(0), arr[2], Double.parseDouble(arr[3]), Boolean.parseBoolean(arr[4]), arr[5]);
    }

    static DriversLicense deserializeFromJSON (String serializedLicense) {

        serializedLicense = serializedLicense.replaceAll("[{}\"]", "");
        String[] arr = serializedLicense.split("[:,]");
        return new DriversLicense(arr[1], arr[3].charAt(0), arr[5], Double.parseDouble(arr[7]), Boolean.parseBoolean(arr[9]), arr[11]);
    }
}
