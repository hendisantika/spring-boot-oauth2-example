package com.hendisantika.springbootoauth2.controller;

import com.hendisantika.springbootoauth2.model.Party;
import com.hendisantika.springbootoauth2.repository.PartyRepository;
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

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/29/17
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */

@RestController
@RequestMapping("/parties")
public class PartyController {
    @Autowired
    private PartyRepository partyRepo;

    @GetMapping
    public ResponseEntity<Collection<Party>> getParties() {
        return new ResponseEntity<>(partyRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Party> getParty(@PathVariable long id) {
        Party party = partyRepo.findById(id).get();

        if (party != null) {
            return new ResponseEntity<>(partyRepo.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(partyRepo.findById(id).get(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addParty(@RequestBody Party party) {
        return new ResponseEntity<>(partyRepo.save(party), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteParty(@PathVariable long id) {
        partyRepo.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
