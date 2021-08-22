import apiPackage.ApiClass;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class ApiTest extends ApiClass {
    Properties prop;
    boolean soldPets;

    @BeforeTest
    public void setUp() {
        prop = initProperties();
    }

    @Test(priority = 1, description = "creating a pet with a unique id")
    public void createPet() {
        Assert.assertEquals(postNewPet(), 200);
    }

    @Test(priority = 2, description = "upload an image to the new pet")
    public void uploadImageToPet() {
        Assert.assertEquals(uploadImage(), 200);
    }

    @Test(priority = 3, description = "search for the new pet")
    public void searchNewPet() {
        Assert.assertEquals(getPet(), prop.getProperty("responseBody"));
    }

    @Test(priority = 4, description = "search for the sold pets")
    public void searchSoldPets() {
        soldPets = getSoldPets().contains(prop.getProperty("responseBody"));
        Assert.assertTrue(soldPets);
    }


}
