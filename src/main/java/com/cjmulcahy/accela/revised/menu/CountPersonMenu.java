package com.cjmulcahy.accela.revised.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cjmulcahy.accela.revised.UIMediator;
import com.cjmulcahy.accela.revised.command.CommandInput;

@Component
public class CountPersonMenu extends AbstractMenu{

  @Autowired
  private CommandInput readCommand;

    @Override
    public void display() {
        System.out.println("***********Persons count*************");
        System.out.println("Press any number to continue");
    }

    @Override
    public void display(int selection) {
        setDisplayRequired(false);
    }

    @Override
    public void callMediatorAction() {
        readCommand.processInput();
        System.out.println("******Person Count "+((UIMediator)mediator).getPersonCount()+"*********");
    }

    @Override
    public boolean isDisplayRequired() {
        return isDisplayRequired;
    }


}
