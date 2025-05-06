package hooks;

import java.net.UnknownHostException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    
    @Before
    public void setUp() throws InterruptedException, UnknownHostException {
        System.out.println("Launching browser...");
        BaseClass.initDriver();  
    }

    @After
    public void tearDown() {
        System.out.println("Closing browser...");
        BaseClass.quitDriver();
    }
}
