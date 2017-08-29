package com.hendisantika.springbootoauth2.repository;

import com.hendisantika.springbootoauth2.model.Person;
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
 * Time: 6:02 AM
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest {
    @Autowired
    private PersonRepository repository;

    @Test
    public void repositorySavesPerson() {
        Person person = new Person();
        person.setName("Sasuke");
        person.setAge(25);

        Person result = repository.save(person);

        assertEquals(result.getName(), "Sasuke");
        assertEquals(result.getAge(), 25);
    }
}
