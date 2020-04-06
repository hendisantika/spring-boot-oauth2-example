package com.hendisantika.springbootoauth2.service;

import com.hendisantika.springbootoauth2.model.Person;
import com.hendisantika.springbootoauth2.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by IntelliJ IDEA.
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/30/17
 * Time: 6:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class DrinkingBuddyServiceTest {
    private PersonRepository repository;
    private DrinkingBuddyService service;

    @Before
    public void prepare() {
        repository = mock(PersonRepository.class);
        service = new DrinkingBuddyService(repository);
    }

    @Test
    public void findBuddyTest() {
        List<Person> people = new ArrayList<Person>();

        Person p1 = new Person();
        p1.setId(1l);
        p1.setName("Hendi");
        p1.setAge(25);
        people.add(p1);

        Person p2 = new Person();
        p2.setId(2l);
        p2.setName("Sasuke");
        p2.setAge(22);
        people.add(p2);

        Person p3 = new Person();
        p3.setId(1l);
        p3.setName("Kakashi");
        p3.setAge(35);
        people.add(p3);

        when(repository.findAll()).thenReturn(people);

        assertEquals(service.findBuddy(p1), p2);
    }
}
