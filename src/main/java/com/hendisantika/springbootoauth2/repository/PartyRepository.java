package com.hendisantika.springbootoauth2.repository;

import com.hendisantika.springbootoauth2.model.Party;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/28/17
 * Time: 10:56 AM
 * To change this template use File | Settings | File Templates.
 */

@Repository
public interface PartyRepository extends CrudRepository<Party, Long>{
    Collection<Party> findAll();
}
