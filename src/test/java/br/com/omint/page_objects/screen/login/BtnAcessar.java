package br.com.omint.page_objects.screen.login;

import br.com.omint.utils.enums.SelectorType;
import br.com.omint.utils.ElementManager;
import io.appium.java_client.MobileElement;

public class BtnAcessar {

    private static ElementManager elementManager;

    public BtnAcessar(ElementManager elementManager){
        this.elementManager = elementManager;
    }

    public MobileElement getInstance(){
        return elementManager.getElement("btnAcessar", SelectorType.XPATH);
    }
}
