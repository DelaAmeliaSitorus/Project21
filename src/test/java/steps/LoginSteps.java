package steps;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage;

    @Given("saya membuka halaman login")
    public void bukaHalamanLogin() {
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage = new LoginPage(driver);
    }

    @When("saya memasukkan username {string}")
    public void inputUsername(String username) {
        loginPage.enterUsername(username);
    }

    @When("saya memasukkan password {string}")
    public void inputPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("saya menekan tombol login")
    public void klikLogin() {
        loginPage.clickLogin();
    }

    @Then("login berhasil ditampilkan")
    public void loginBerhasil() {
        assertTrue(loginPage.getMessage().toLowerCase().contains("secure"));
    }

    @Then("muncul pesan login gagal")
    public void loginGagal() {
        assertTrue(loginPage.getMessage().toLowerCase().contains("invalid"));
    }


}
