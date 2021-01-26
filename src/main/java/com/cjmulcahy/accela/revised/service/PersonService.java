package com.cjmulcahy.accela.revised.service;

import java.util.List;


import com.cjmulcahy.accela.revised.domain.Person;

public interface PersonService {

    public void createPerson(Person person);
    
    public void updatePerson(Person person );
    
    public void deletePerson(int id);
    
    public int countPersons();
    
    public List<Person> listPersons();
    
    public Person findPersonById(int id);
    
}
