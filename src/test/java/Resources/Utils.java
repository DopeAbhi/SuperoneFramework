package Resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class Utils {
    public static RequestSpecification req;

    public static String getGlobalValue(String key) throws IOException
    {
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream("/home/abhay/IdeaProjects/SuperoneFramework/src/test/java/Resources/global.properties");
        prop.load(fis);
        return prop.getProperty(key);

    }
    public RequestSpecification requestSpecification() throws IOException

    {

        if (req==null) {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            req = new RequestSpecBuilder().setBaseUri(getGlobalValue("RestAssured.baseURI"))
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Device-Type", "WEB")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();   //request spec builder
            return req;
        }
        return req;
    }
}
