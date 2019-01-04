import org.junit.Test;
import search.SearchPage;


public class TestHome extends SearchPage {//removed CommonAPI  and now extends SearchPage
    @Test
    public void test1(){
        //typeOnElement("#twotabsearchtextbox", "Books");//write new method and pass the locator & value here from below

        //driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Books");
        //type-method shifted to CommonAPI with small changes and deactivated here and replaced by above new method.

        searchMenu(); //call searchMenu

    }
}

