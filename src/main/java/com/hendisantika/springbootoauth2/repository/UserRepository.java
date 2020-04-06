package com.hendisantika.springbootoauth2.repository;

import com.hendisantika.springbootoauth2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
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
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Find a user by username
     *
     * @param username the user's username
     * @return user which contains the user with the given username or null.
     */
    User findOneByUsername(String username);
}
