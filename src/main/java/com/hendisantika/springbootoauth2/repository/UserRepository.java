package com.hendisantika.springbootoauth2.repository;

import com.hendisantika.springbootoauth2.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/28/17
 * Time: 11:00 AM
 * To change this template use File | Settings | File Templates.
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
