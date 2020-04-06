package com.hendisantika.springbootoauth2.controller;

import com.hendisantika.springbootoauth2.model.Party;
import com.hendisantika.springbootoauth2.model.Person;
import com.hendisantika.springbootoauth2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/29/17
 * Time: 11:16 AM
 * To change this template use File | Settings | File Templates.
 */

@RestController
@RequestMapping("/people")
public class PersonController {
    @Autowired
    private PersonRepository personRepo;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Person>> getPeople() {
        return new ResponseEntity<>(personRepo.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson(@PathVariable long id) {
        Person person = personRepo.findOne(id);

        if (person != null) {
            return new ResponseEntity<>(personRepo.findOne(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(personRepo.findOne(id), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personRepo.save(person), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePerson(@PathVariable long id, Principal principal) {
        Person currentPerson = personRepo.findByUsername(principal.getName());

        if (currentPerson.getId() == id) {
            personRepo.delete(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/{id}/parties", method = RequestMethod.GET)
    public ResponseEntity<Collection<Party>> getPersonParties(@PathVariable long id) {
        Person person = personRepo.findOne(id);

        if (person != null) {
            return new ResponseEntity<>(person.getParties(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(person.getParties(), HttpStatus.NOT_FOUND);
        }
    }

}
