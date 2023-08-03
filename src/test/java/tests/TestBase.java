package tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import properties.SystemProperties;

public abstract class TestBase {

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = SystemProperties.baseUrlProperty;
        RestAssured.basePath = SystemProperties.basePathProperty;
    }

}


