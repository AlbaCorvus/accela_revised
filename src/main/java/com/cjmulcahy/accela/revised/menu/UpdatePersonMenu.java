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
public class UpdatePersonMenu extends AbstractMenu {

    @Autowired
    private CommandInput updateCommand;

    @Autowired
    private CommandInput listCommand;

    @Autowired
    private CommandInput findCommand;

    private Set<Address> addresses;

    @Override
    public void display() {
        System.out.println("**Update Person**");
        System.out.println("**Choose from list of people who to edit**");
        showListPersonUI();
        System.out.println("Enter person's ID to update");
    }

    @Override
    public void display(int selection) {
        findCommand.processInput(selection);
        while (isDisplayRequired) {
            displayPersonDetails(((UIMediator) mediator).getPerson());
            showUpdatePersonFieldSelection(scannerUtils.listenForIntegerWithRange(scanner, 0, 4));
        }
    }

    private void showUpdatePersonFieldSelection(int selection) {
        switch (selection) {
        case 1:
            showUpdateFirstName();
            break;
        case 2:
            showUpdateLastName();
            break;
        case 3:
            showUpdateAdresses();
            showUpdateAddressSelection(scannerUtils.listenForAnyInt(scanner));
            break;
        case 4:
            setDisplayRequired(false);
            break;
        default:
        }
    }

    private void displayPersonDetails(Person person) {
        System.out.println("***********EDIT PERSON************");
        System.out.println("**-- " + person.getFirstName() + " " + person.getLastName() + "  --**");
        System.out.println("1.) Change First Name [Press 1]");
        System.out.println("2.) Change Last Name [Press 2]");
        System.out.println("3.) Change Addresses [Press 3]");
        System.out.println("4.) Save Changes [Press 4]");
    }

    private void showUpdateFirstName() {
        System.out.println("**Update FirstName**");
        ((UIMediator) mediator).getPerson().setFirstName(scannerUtils.listenForString(scanner));
    }

    private void showUpdateLastName() {
        System.out.println("**Update LastName**");
        ((UIMediator) mediator).getPerson().setLastName(scannerUtils.listenForString(scanner));
    }

    private void showUpdateAdresses() {
        ((UIMediator) mediator)
                .getPerson()
                .getAddresses()
                .forEach(
                        address -> {
                            System.out.println("**Update Address**");
                            System.out.println("**" + address.getStreet() + " " + address.getCity() + " " + address.getState() + " "
                                    + address.getPostalCode() + "[Press " + address.getId() + " to select]**");
                        });
    }

    private void showUpdateAddressSelection(int addressId) {
        addresses = new HashSet<>();
        Address address = ((UIMediator) mediator).getPerson().getAddressById(addressId);
        System.out.println(address.getStreet() + " Enter new Street address :: ");
        address.setStreet(scannerUtils.listenForString(scanner));
        System.out.println(address.getCity() + " Enter new City address :: ");
        address.setCity(scannerUtils.listenForString(scanner));
        System.out.println(address.getState() + " Enter new State address :: ");
        address.setState(scannerUtils.listenForString(scanner));
        System.out.println(address.getPostalCode() + " Enter new Postal Code address :: ");
        address.setPostalCode(scannerUtils.listenForString(scanner));
        addresses.add(address);
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
        updateCommand.processInput();
    }

    @Override
    public boolean isDisplayRequired() {
        return isDisplayRequired;
    }

}
