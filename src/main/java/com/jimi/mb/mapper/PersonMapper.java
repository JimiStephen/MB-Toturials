package com.jimi.mb.mapper;

import com.jimi.mb.domain.Person;

public interface PersonMapper {
    Person selectPerson(int id);
 
    Person selectPersonByName(String name);
 
    void insertPerson(Person person);
 
    void updatePerson(Person person);
 
    void deletePerson(Person person);
    
    void deleteAllPerson();
}