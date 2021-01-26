package com.cjmulcahy.accela.revised.menu;


import org.springframework.stereotype.Component;



@Component
public class MainMenu extends AbstractMenu{

    
    @Override
    public void display() {
        System.out.println("****************************************");
        System.out.println("1.) Create Person [Press 1]");
        System.out.println("2.) Update Person [Press 2]");
        System.out.println("3.) Delete Person [Press 3]");
        System.out.println("4.) Count People [Press 4]");
        System.out.println("5.) List People [Press 5]");
        System.out.println("6.) Exit [Press 0]");
        System.out.println("*****************************************");
    }

    @Override
    public void display(int selection) {
       
    }

    @Override
    public void callMediatorAction() {
        
    }

    @Override
    public boolean isDisplayRequired() {
        // TODO Auto-generated method stub
        return false;
    }


}
