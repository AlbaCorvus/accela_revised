package com.cjmulcahy.accela.revised.command;

import org.springframework.beans.factory.annotation.Autowired;

import com.cjmulcahy.accela.revised.CRUDMediator;

public class UpdateCommand implements CommandInput{

    private CRUDMediator mediator;
    
    @Autowired
    public UpdateCommand(CRUDMediator mediator){
        this.mediator = mediator;
    }
    
    @Override
    public void processInput() {
        mediator.update();
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
