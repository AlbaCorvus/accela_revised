package com.cjmulcahy.accela.revised.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cjmulcahy.accela.revised.UIMediator;
import com.cjmulcahy.accela.revised.command.CommandInput;
import com.cjmulcahy.accela.revised.domain.Person;

@Component
public class ListPersonMenu extends AbstractMenu{

    @Autowired
    private CommandInput listCommand;

    @Override
    public void display() {
        System.out.println("*******Show people*********");
        System.out.println("*******Press Any Number To Continue*********");
    }

    @Override
    public void display(int selection) {
        setDisplayRequired(false);
    }

    private void displayInformation(Person person){
        System.out.println("Person ID : " + person.getId() + " :: " + person.getFirstName() + " " + person.getLastName());
        person.getAddresses().forEach(address -> {
            System.out.println("Address Street :: "+address.getStreet()+" City :: "+address.getCity() +" State :: "+address.getState()+" PostalCode :: "+address.getPostalCode());
        });
        System.out.println("******************************************************************");
    }

    @Override
    public void callMediatorAction() {
        listCommand.processInput();
        ((UIMediator) mediator).getPersonList().forEach(person -> displayInformation(person));
    }

    @Override
    public boolean isDisplayRequired() {
        return isDisplayRequired;
    }

}
