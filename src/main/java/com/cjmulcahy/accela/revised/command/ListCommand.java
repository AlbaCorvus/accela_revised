package com.cjmulcahy.accela.revised.command;

import org.springframework.beans.factory.annotation.Autowired;

import com.cjmulcahy.accela.revised.CRUDMediator;

public class ListCommand implements CommandInput{

    private CRUDMediator mediator;
    
    @Autowired
    public ListCommand(CRUDMediator mediator){
        this.mediator = mediator;
    }
    
    @Override
    public void processInput() {
        mediator.listPeople();
    }

    @Override
    public void processInput(int input) {
        
    }

    @Override
    public void processInput(String input) {
        
    }

}
