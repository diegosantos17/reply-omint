package br.com.omint;

import br.com.omint.page_objects.screen.common.BtnIconeMenu;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Listar os atendimentos")
public class ListarAtendimentosTest extends BaseTest{

    public void listarAtendimentos() throws Exception {
        AutenticarTest autenticarTest = new AutenticarTest();
        autenticarTest.autenticarApp();

        System.out.println("Aguardando carregamento da tela inicial");
        Thread.sleep(120000);

        System.out.println("Abrindo menu Lateral");
        MobileElement btnIconeMenu = new BtnIconeMenu(elementManager).getInstance();
        btnIconeMenu.click();
    }

    @Test
    public void listarAtendimentosTest() throws Exception {
        listarAtendimentos();
    }
}