package com.hendisantika.springbootoauth2.repository;

import com.hendisantika.springbootoauth2.model.Party;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/30/17
 * Time: 6:00 AM
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class PartyRepositoryTest {
    @Autowired
    private PartyRepository repository;

    @Test
    public void repositorySavesParty() {
        Party party = new Party();
        party.setLocation("Bandung");

        Party result = repository.save(party);

        assertEquals(result.getLocation(), "Bandung");
    }
}
