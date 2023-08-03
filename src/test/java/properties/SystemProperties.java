package properties;

public class SystemProperties {

    public static String baseUrlProperty = System.getProperty("baseUrl", "https://reqres.in"),
            basePathProperty = System.getProperty("basePath", "/api");
}
