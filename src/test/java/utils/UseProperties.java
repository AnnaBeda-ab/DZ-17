package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static java.util.Objects.isNull;

public class UseProperties {
    public static final String PATH_TO_RESOURSE = "src/test/resources/";
    public static final String PROPERTY_FILE_NAME = "property.properties";
    public static String userName;
    public static String token;
    public static String apiEndpoint;
    public static String baseURL;
    public static String dbURL;

    private static String getPropetryValue(String pathToFile, String propertyFileName, String propertyName) {
        Properties property = new Properties();
        try (FileInputStream fis = new FileInputStream(pathToFile+propertyFileName)) {
            property.load(fis);
        } catch (IOException exep) {
            throw new RuntimeException(exep);
        }
        return property.getProperty(propertyName);

    }

    public static String propertyValue(String pathToFile, String propertyFileName, String propertyName) {
        String systemProperty = System.getProperty(propertyName);
        return !isNull(systemProperty) ? systemProperty : getPropetryValue(pathToFile, propertyFileName, propertyName);
    }

    public static final void setupInstanse(String instanseName) {
        switch (instanseName) {
            case "remote": {
                apiEndpoint = propertyValue(PATH_TO_RESOURSE, PROPERTY_FILE_NAME, "apiRemoteEndpoint");
                baseURL = propertyValue(PATH_TO_RESOURSE, PROPERTY_FILE_NAME, "RemoteURL");
                userName = propertyValue(PATH_TO_RESOURSE, PROPERTY_FILE_NAME, "username");
                token = propertyValue(PATH_TO_RESOURSE, PROPERTY_FILE_NAME, "apiRemoteToken");
                dbURL=propertyValue(PATH_TO_RESOURSE,PROPERTY_FILE_NAME,"URL_DB");
            }
            default: {
                apiEndpoint = propertyValue(PATH_TO_RESOURSE, PROPERTY_FILE_NAME, "apiLocalEndpoint");
                baseURL = propertyValue(PATH_TO_RESOURSE, PROPERTY_FILE_NAME, "localURL");
                userName = propertyValue(PATH_TO_RESOURSE, PROPERTY_FILE_NAME, "username");
                token = propertyValue(PATH_TO_RESOURSE, PROPERTY_FILE_NAME, "apiLocalToken");
                dbURL=propertyValue(PATH_TO_RESOURSE,PROPERTY_FILE_NAME,"URL_DB");
            }
        }
    }
}



