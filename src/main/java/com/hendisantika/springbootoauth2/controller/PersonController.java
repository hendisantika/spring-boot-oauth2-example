package com.hendisantika.springbootoauth2.controller;

import com.hendisantika.springbootoauth2.model.Party;
import com.hendisantika.springbootoauth2.model.Person;
import com.hendisantika.springbootoauth2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping
    public ResponseEntity<Collection<Person>> getPeople() {
        return new ResponseEntity<>(personRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable long id) {
        Person person = personRepo.findById(id).get();

        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(person, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personRepo.save(person), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable long id, Principal principal) {
        Person currentPerson = personRepo.findByUsername(principal.getName());

        if (currentPerson.getId() == id) {
            personRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(value = "/{id}/parties")
    public ResponseEntity<Collection<Party>> getPersonParties(@PathVariable long id) {
        Person person = personRepo.findById(id).get();

        if (person != null) {
            return new ResponseEntity<>(person.getParties(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(person.getParties(), HttpStatus.NOT_FOUND);
        }
    }

}
