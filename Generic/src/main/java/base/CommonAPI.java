package base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;

public class CommonAPI {
    public WebDriver driver = null;
    @Parameters({"url"})//add this line to make it a generic url parameters
    @BeforeMethod
    public void setUP(String url) {//put parameter - String url within parenthesis
        System.setProperty("webdriver.chrome.driver", "/Users/peoplentech/develop/automation/Web-Automation-Framework/Generic/browser-driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get("https://www.amazon.com"); //replace hardcoding with the following:
        //driver.get(url);//add navigate, remove get
        driver.navigate().to(url);//navigate will do the functon of back and forth
    }
    @AfterMethod
    public void cleanUp() {
        driver.close();
    }//type
    //Shift the type-method from TestHome to CommonAPI, with few changes as follows:>
    public void typeOnCss(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }
    //we can use alternative typeOnID method
    // If we don’t have cssCelector.
    public void typeOnID(String locator, String value) {
        driver.findElement(By.id(locator)).sendKeys(value);
    }
    // OR can go for following alternative way where
    // successive attempts will be carried out if the precedent one wasn't successful
    // below methods are for simply type
    public void typeOnElement(String locator, String value) {
        try{
            driver.findElement(By.cssSelector(locator)).sendKeys(value);
        }catch (Exception ex1){
            try {
                System.out.println("First attempt was not successful");
                driver.findElement(By.name(locator)).sendKeys(value);

                }catch (Exception ex2){
                try {
                    System.out.println("Second attempt was not successful");
                    driver.findElement(By.xpath(locator)).sendKeys(value);
                }catch (Exception ex3){
                    System.out.println("Third attempt was not successful");
                    driver.findElement(By.id(locator)).sendKeys(value);
                }
            }
        }
    }
    // copy above methods & paste here, added Keys.ENTER and they are for type & enter purpose
    public void typeOnElementNEnter(String locator, String value) {
        try{
            driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        }catch (Exception ex1){
            try {
                System.out.println("First attempt was not successful");
                driver.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
            }catch (Exception ex2){
                try {
                    System.out.println("Second attempt was not successful");
                    driver.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
                }catch (Exception ex3){
                    System.out.println("Third attempt was not successful");
                    driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
                }
            }
        }
    }
    public void clearField(String locator){
        driver.findElement(By.id(locator)).clear();
    }
    public void navigateBack(){
        driver.navigate().back();
    }

}