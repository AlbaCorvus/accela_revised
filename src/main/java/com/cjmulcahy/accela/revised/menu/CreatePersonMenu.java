package com.cjmulcahy.accela.revised.menu;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cjmulcahy.accela.revised.UIMediator;
import com.cjmulcahy.accela.revised.command.CommandInput;
import com.cjmulcahy.accela.revised.domain.Address;
import com.cjmulcahy.accela.revised.domain.Person;

@Component
public class CreatePersonMenu extends AbstractMenu{

    
    @Autowired
    private Person person;
    
    @Autowired
    private CommandInput createCommand;
    
    private Set<Address> addresses = new HashSet<>();
    
    public CreatePersonMenu(){
        
    }

    @Override
    public void display() {
        System.out.println("**Create Person**");
        System.out.println("[PRESS 1] Enter First Name : ");
        System.out.println("[PRESS 2] Enter Last Name : ");
        System.out.println("[PRESS 3] Enter Addresses : ");
        System.out.println("[PRESS 4] Save to database ");
    }

    @Override
    public void display(int selection) {
        switch(selection){
        case 1:
            System.out.println("Enter First Name : ");
            person.setFirstName(scannerUtils.listenForString(scanner));
            display();
            break;
        case 2:
            System.out.println("Enter Last Name : ");
            person.setLastName(scannerUtils.listenForString(scanner));
            display();
            break;
        case 3:
            displayCreateAddresses();
            display();
            break;
        case 4:
            setDisplayRequired(false);
        }
    }
    
    public void displayCreateAddresses(){
        Address address = new Address();
        System.out.println("*****Enter Addresses*********");
        System.out.println("Enter Address Street: ");
        address.setStreet(scannerUtils.listenForString(scanner));
        System.out.println("Enter Address City : ");
        address.setCity(scannerUtils.listenForString(scanner));
        System.out.println("Enter Address State : ");
        address.setState(scannerUtils.listenForString(scanner));
        System.out.println("Enter Address Postal Code : ");
        address.setPostalCode(scannerUtils.listenForString(scanner));
        addresses.add(address);
    }

    @Override
    public void callMediatorAction() {
        ((UIMediator)mediator).setPerson(person);
        createCommand.processInput();
    }

    @Override
    public boolean isDisplayRequired() {
        return isDisplayRequired;
    }

   

}
