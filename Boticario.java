package site;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Boticario{
    String url;
    WebDriver driver;

@Before
    public void inicializar(){

    ChromeOptions chOptions = new ChromeOptions(); //criando/intanciando um objeto de configuracao do chrome driver
    chOptions.addArguments("--disable-notifications"); //desabilita  popup do proprio chrome

    url = "https://www.boticario.com.br/";
    //System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); com pasta somente driver
    System.setProperty("webdriver.chrome.driver", "Drivers/Chrome/87/chromedriver.exe");
    driver = new ChromeDriver(chOptions); //dentro do parenteses eu coloco o objeto de configuracao
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);


}

@After
     public void finalizar(){
     //driver.quit();



}


@Test
    public void testeBoticario() throws InterruptedException {
    driver.get(url);
    driver.findElement(By.id("onetrust-accept-btn-handler")).click(); //fazer o segundo popup do  browser
    //driver.findElement(By.id("onesignal-slidedown-cancel-button")).click(); //talvez  depois popup dop browser
    driver.findElement(By.id("autocomplete-input")).sendKeys("Lili"+ Keys.ENTER);
    driver.findElement(By.xpath("//body/main[1]/section[1]/div[1]/div[4]/a[1]/img[1]")).click();

    assertEquals("Combo Presente Lily: Creme Acetinado Hidratante Desodorante Corporal 250g + Caixa de Presente",driver.findElement(By.xpath("//h1[contains(text(),'Combo Presente Lily: Creme Acetinado Hidratante De')]")).getText());
    assertEquals("R$ 92,40",driver.findElement(By.xpath("//div[contains(text(),'R$ 92,40')]")).getText());





    }


}
