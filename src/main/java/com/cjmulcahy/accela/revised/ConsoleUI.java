package com.cjmulcahy.accela.revised;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.cjmulcahy.accela.revised.enums.MenuType;
import com.cjmulcahy.accela.revised.menu.Menu;
import com.cjmulcahy.accela.revised.menu.MenuFactory;
import com.cjmulcahy.accela.revised.utils.ScannerUtils;

public class ConsoleUI {
    @Autowired
    private MenuFactory menuFactory;
    
    public ConsoleUI() {
        
    }
    
    public void startConsole(){
        ScannerUtils scannerUtils = new ScannerUtils();
        
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {

                Menu menu = menuFactory.getMenu(MenuType.MAIN_MENU);
                menu.display();
                switch (scannerUtils.listenForInt(scanner)) {
                case 0:
                    System.exit(0);
                case 1:
                    initialiseMenu(scannerUtils, scanner, 1);
                    break;
                case 2:
                    initialiseMenu(scannerUtils, scanner, 2);
                    break;
                case 3:
                    initialiseMenu(scannerUtils, scanner, 3);
                    break;
                case 4:
                    initialiseMenu(scannerUtils, scanner, 4);
                    break;
                case 5:
                    initialiseMenu(scannerUtils, scanner, 5);
                    break;
                case -1:
                    break;
                }
            }
        }
    }

    private void initialiseMenu(ScannerUtils scannerUtils, Scanner scanner, int selection) {
        Menu menu;
        menu = menuFactory.getMenu(MenuType.getMenuType(selection));
        menu.display();
        while(menu.isDisplayRequired()){
        menu.display(scannerUtils.listenForAnyInt(scanner));
        }
        menu.callMediatorAction();
    }
    
}
