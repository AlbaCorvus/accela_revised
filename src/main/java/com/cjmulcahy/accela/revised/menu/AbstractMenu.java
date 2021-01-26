package com.cjmulcahy.accela.revised.menu;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.cjmulcahy.accela.revised.CRUDMediator;
import com.cjmulcahy.accela.revised.utils.ScannerUtils;


public abstract class AbstractMenu implements Menu{
    
    protected boolean isDisplayRequired = true;
    
    @Autowired
    protected CRUDMediator mediator;
    
    @Autowired
    protected Scanner scanner;

    @Autowired
    protected ScannerUtils scannerUtils;

    protected AbstractMenu(){
        
    }

    
    @Override
    public void display() {
        
    }

    @Override
    public void display(int selection) {
        
    }
    
    public abstract void callMediatorAction();
    
    
    protected void setDisplayRequired(boolean isDisplayRequired){
        this.isDisplayRequired = isDisplayRequired;
    }
    

}
