package com.cjmulcahy.accela.revised;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cjmulcahy.accela.revised.domain.Person;
import com.cjmulcahy.accela.revised.service.PersonService;

public class UIMediator implements CRUDMediator{
    
    private List<Person> people;
    
    private Person person;
    
    private int personCount;
    
    @Autowired
    private PersonService personService;

    @Override
    public void create() {
        personService.createPerson(person);
    }

    @Override
    public void readCount() {
        personCount = personService.countPersons();
    }

    @Override
    public void update() {
        personService.updatePerson(person);
    }

    @Override
    public void delete() {
        personService.deletePerson(((Long)person.getId()).intValue());
    }


    public void setPerson(Person person){
        this.person = person;
    }
    
    public int getPersonCount(){
        return personCount;
    }
    
    public List<Person> getPersonList(){
        return people;
    }
    
    public Person getPerson(){
        return person;
    }

    @Override
    public void listPeople() {
        people = personService.listPersons();
    }

    @Override
    public void findPersonById(int id) {
        setPerson(personService.findPersonById(id));
    }
    
}
