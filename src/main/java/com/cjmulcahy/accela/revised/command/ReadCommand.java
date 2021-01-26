package com.cjmulcahy.accela.revised.command;

import org.springframework.beans.factory.annotation.Autowired;

import com.cjmulcahy.accela.revised.CRUDMediator;

public class ReadCommand implements CommandInput{

private CRUDMediator mediator;
    
    @Autowired
    public ReadCommand(CRUDMediator mediator){
        this.mediator = mediator;
    }
    @Override
    public void processInput() {
        mediator.readCount();
    }
    @Override
    public void processInput(int input) {
        
    }
    @Override
    public void processInput(String input) {
        
    }

}
