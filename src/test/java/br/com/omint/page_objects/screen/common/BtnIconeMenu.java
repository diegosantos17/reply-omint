package br.com.omint.page_objects.screen.common;

import br.com.omint.utils.enums.SelectorType;
import br.com.omint.utils.ElementManager;
import io.appium.java_client.MobileElement;

public class BtnIconeMenu {
    private static ElementManager elementManager;

    public BtnIconeMenu(ElementManager elementManager){
        this.elementManager = elementManager;
    }

    public MobileElement getInstance(){
        return elementManager.getElement("btnIconeMenu", SelectorType.XPATH);
    }
}
