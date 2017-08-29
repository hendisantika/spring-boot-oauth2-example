package com.hendisantika.springbootoauth2.controller;

import com.hendisantika.springbootoauth2.model.Party;
import com.hendisantika.springbootoauth2.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Party>> getParties() {
        return new ResponseEntity<>(partyRepo.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Party> getParty(@PathVariable long id) {
        Party party = partyRepo.findOne(id);

        if (party != null) {
            return new ResponseEntity<>(partyRepo.findOne(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(partyRepo.findOne(id), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addParty(@RequestBody Party party) {
        return new ResponseEntity<>(partyRepo.save(party), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePartyn(@PathVariable long id) {
        partyRepo.delete(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
