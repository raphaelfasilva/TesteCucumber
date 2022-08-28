import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {
    public WebDriver webDriver;
    @Dado("que eu esteja no site: {string}")
    public void que_eu_esteja_no_site(String string){
        System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(string);
    }
    @Quando("fizer a busca pelo produto: {string}")
    public void fizer_a_busca_pelo_produto(String string) {
        WebElement barrabusca  = webDriver.findElement(By.className("gLFyf"));
        barrabusca.click();
        barrabusca.sendKeys("playstation 5", Keys.ENTER);
    }
    @Então("verificar se existe resultado: {string}")
    public void verificar_se_existe_resultado(String string) {
        WebElement primeiroelemento = webDriver.findElement(By.className("srp"));
        String texto = primeiroelemento.getText();
        Assertions.assertTrue(texto.contains(string));
    }
}
