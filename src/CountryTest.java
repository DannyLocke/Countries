import com.ironyard.Country;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Created by dlocke on 11/29/16.
 */
public class CountryTest {

    @Test
    public void testCountry() throws Exception{
        Country country = new Country();
        country.name = "Test Country";
        country.getName();
        assertTrue(country.getName() == country.name);
    }
}
