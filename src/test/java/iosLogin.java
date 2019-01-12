import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class iosLogin {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "iosLogin";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeEach
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "75da72cde323f2939131ed4aefd11677a3459bdb");
        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.ALL);
    }

    @Test
    public void testiosLogin() {
        driver.findElement(By.xpath("//*[@text='Performio' and (./preceding-sibling::* | ./following-sibling::*)[@text='Mail']]")).click();
        driver.findElement(By.xpath("//*[@placeholder='domain']")).click();
        driver.findElement(By.xpath("//*[@text='Performio' and ./*[@class='UIAView']]")).sendKeys("test");
        driver.findElement(By.xpath("//*[@text='Continue']")).click();
        new WebDriverWait(driver, 10);//.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Username']")));
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("kate");
        try{Thread.sleep(5000);} catch(Exception ignore){}
        driver.findElement(By.xpath("//*[@placeholder='Password']")).click();
        driver.getKeyboard().sendKeys("Password@123");
        new WebDriverWait(driver, 10);//.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Login']")));
        driver.findElement(By.xpath("//*[@text='Login']")).click();
        new WebDriverWait(driver, 30);//.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Performio' and ./*[@class='UIAView']]")));
        driver.findElement(By.xpath("//*[@text='Performio' and ./*[@class='UIAView']]")).sendKeys("11111111");
        new WebDriverWait(driver, 60);//.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='' and @class='UIAImage' and ./*[@class='UIAStaticText']]")));
        driver.findElement(By.xpath("//*[@text='' and @class='UIAImage' and ./*[@class='UIAStaticText']]")).click();
        driver.findElement(By.xpath("//*[@text=' Custom Table']")).click();
        new WebDriverWait(driver, 10);//.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Custom Table']")));
        driver.findElement(By.xpath("//*[@text='Custom Table']")).click();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}