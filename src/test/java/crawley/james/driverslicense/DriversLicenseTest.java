package crawley.james.driverslicense;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jamescrawley on 10/11/16.
 */
public class DriversLicenseTest {

    @Test
    public void serializeCSVTest () {
        DriversLicense driversLicense = new DriversLicense("John Smith", 'M', "04-27-1983", 134.2, true, " ");
        String actual = driversLicense.serializeToCSV();
        assertEquals("The object should be serialized as \"John Smith,M,04-27-1983,134.20,true, \"", "John Smith,M,04-27-1983,134.20,true, ", actual);

    }

    @Test
    public void deserializeCSVTest () {
        DriversLicense driversLicense = new DriversLicense("John Smith", 'M', "04-27-1983", 134.2, true, " ");
        String serialized = driversLicense.serializeToCSV();
        DriversLicense deserialized = DriversLicense.deserializeFromCSV(serialized);
        assertEquals("The derserialized object should be equal to the original.", driversLicense, deserialized);

    }

    @Test
    public void serializeJSONTest () {
        DriversLicense driversLicense = new DriversLicense("John Smith", 'M', "04-27-1983", 134.2, true, " ");
        String expected = "{\"name\":\"John Smith\", \"gender\":\"M\", \"dateOfBirth\":\"04-27-1983\", \"weight\":134.20, \"organDonor\":true, \"endorsements\":\" \"}";
        String actual = driversLicense.serializeToJSON();
        assertEquals("The object should be serialized as " + expected,  expected, actual);

    }

    @Test
    public void deserializeJSONTest () {
        DriversLicense driversLicense = new DriversLicense("John Smith", 'M', "04-27-1983", 134.2, true, " ");
        String serialized = driversLicense.serializeToJSON();
        DriversLicense deserialized = DriversLicense.deserializeFromJSON(serialized);
        assertEquals("The derserialized object should be equal to the original.", driversLicense, deserialized);

    }


}
