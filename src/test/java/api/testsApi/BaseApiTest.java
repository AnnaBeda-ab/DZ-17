package api.testsApi;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static utils.UseProperties.setupInstanse;

public class BaseApiTest {
    @BeforeMethod
    public void setUp(){setupInstanse("local");}
}
