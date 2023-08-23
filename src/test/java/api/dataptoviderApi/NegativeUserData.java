package api.dataptoviderApi;

import org.testng.annotations.DataProvider;

public class NegativeUserData {
    @DataProvider(name = "NegativeUserData")
    public static Object[][] UserCredentialNegDataProvider() {
        return new Object[][]{
                {"", "admin"},
                {"admin", ""},
                {"", ""},
                //{"admin", "1234567890"},
               // {"1234","admin"}
        };
    }
}

