package com.cjmulcahy.accela.revised.command;

import org.springframework.beans.factory.annotation.Autowired;

import com.cjmulcahy.accela.revised.CRUDMediator;

public class FindCommand implements CommandInput{

private CRUDMediator mediator;
    
    @Autowired
    public FindCommand(CRUDMediator mediator){
        this.mediator = mediator;
    }
    
    @Override
    public void processInput() {
    }

    @Override
    public void processInput(int input) {
        mediator.findPersonById(input);
    }

    @Override
    public void processInput(String input) {
        
    }

}
