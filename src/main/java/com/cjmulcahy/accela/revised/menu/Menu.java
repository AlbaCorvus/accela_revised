package com.cjmulcahy.accela.revised.menu;


public interface Menu extends Mediator{

    public void display();
    
    public void display(int selection);
    
    public boolean isDisplayRequired();
    
}
