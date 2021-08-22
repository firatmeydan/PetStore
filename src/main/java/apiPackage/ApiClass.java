package apiPackage;

import base.BaseCls;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.Properties;

public class ApiClass extends BaseCls {
    Properties prop;

    public ApiClass() {
        prop = initProperties();
    }

    public int postNewPet() {
        RestAssured.baseURI = prop.getProperty("baseURI");
        RequestSpecification request = RestAssured.given();
        request.contentType(prop.getProperty("contentType"));
        request.header(prop.getProperty("apiKey"), prop.getProperty("apiPass"));

        File file = new File(
                "./src/main/resources/newPetBody.json");
        request.body(file);
        Response response = request.post("/pet");

        return response.statusCode();
    }

    public int uploadImage() {
        RestAssured.baseURI = prop.getProperty("baseURI");
        RequestSpecification request = RestAssured.given();
        request.contentType(prop.getProperty("contentTypeImage"));
        request.header(prop.getProperty("apiKey"), prop.getProperty("apiPass"));
        request.accept(prop.getProperty("contentType"));

        File file = new File(
                "./src/main/resources/CuteCat.jpeg");
        request.multiPart("file", file);
        Response response = request.post("/pet/2070/uploadImage");

        return response.statusCode();
    }

    public String getPet() {
        RestAssured.baseURI = prop.getProperty("baseURI");
        RequestSpecification request = RestAssured.given();
        request.header(prop.getProperty("apiKey"), prop.getProperty("apiPass"));
        Response response = request.get("/pet/2070");

        return response.asString();
    }

    public String getSoldPets() {
        RestAssured.baseURI = prop.getProperty("baseURI");
        RequestSpecification request = RestAssured.given();
        request.header(prop.getProperty("apiKey"), prop.getProperty("apiPass"));
        Response response = request.get("/pet/findByStatus?status=sold");

        return response.asString();
    }
}
