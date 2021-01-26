package com.cjmulcahy.accela.revised.command;

import org.springframework.beans.factory.annotation.Autowired;

import com.cjmulcahy.accela.revised.CRUDMediator;

public class CreateCommand implements CommandInput{
    
    private CRUDMediator mediator;
    
    @Autowired
    public CreateCommand(CRUDMediator mediator){
        this.mediator = mediator;
    }
    
    
    @Override
    public void processInput() {
        mediator.create();
    }


    @Override
    public void processInput(int input) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void processInput(String input) {
        // TODO Auto-generated method stub
        
    }

}
