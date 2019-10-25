package br.com.omint;

import br.com.omint.page_objects.screen.login.*;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Autenticar no App")
public class AutenticarTest extends BaseTest{

    public void autenticarApp() throws Exception {
        initAppiumSync();

        Thread.sleep(10000);

        MobileElement btnPermitirLocal = new BtnPermitir(elementManager).getInstance();
        btnPermitirLocal.click();

        MobileElement btnLogin = new BtnLogin(elementManager).getInstance();
        btnLogin.click();

        System.out.println("Autenticando usuário");
        MobileElement inputEmail = new InputEmail(elementManager).getInstance();
        inputEmail.click();
        inputEmail.sendKeys(configManager.getConfiguration("emailLogin"));

        Thread.sleep(5000);
        MobileElement inputPass = new InputPass(elementManager).getInstance();
        inputPass.click();
        inputPass.sendKeys(configManager.getConfiguration("passLogin"));

        MobileElement btnAcessar = new BtnAcessar(elementManager).getInstance();
        btnAcessar.click();

        /*int total = 1 + 1;
        Assertions.assertEquals(total, 2);*/
    }

    @Test
    public void autenticarAppTest() throws Exception {
        autenticarApp();
    }
}