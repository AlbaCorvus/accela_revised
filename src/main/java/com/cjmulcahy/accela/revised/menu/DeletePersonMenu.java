package com.cjmulcahy.accela.revised.menu;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cjmulcahy.accela.revised.UIMediator;
import com.cjmulcahy.accela.revised.command.CommandInput;

@Component
public class DeletePersonMenu extends AbstractMenu {

    @Autowired
    private CommandInput deleteCommand;

    @Autowired
    private CommandInput findCommand;

    @Autowired
    private CommandInput listCommand;

    @Override
    public void display() {
        System.out.println("**Delete Person**");
        System.out.println("**Choose from list of people who to delete**");
        showListPersonUI();
        System.out.println("Enter person's ID to delete");

    }

    @Override
    public void display(int selection) {
        findCommand.processInput(selection);
        setDisplayRequired(false);
    }

    private void showListPersonUI() {
        listCommand.processInput();
        ((UIMediator) mediator).getPersonList().forEach(
                person -> {
                    System.out.println("Person FirstName : " + person.getFirstName() + " Person LastName : " + person.getLastName()
                            + " [Enter Person ID " + person.getId() + " to choose]");
                });
    }

    @Override
    public void callMediatorAction() {
        deleteCommand.processInput();
    }

    @Override
    public boolean isDisplayRequired() {
        return isDisplayRequired;
    }

}
