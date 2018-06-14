package com.anji.springbootoauth2demo.jpa;

import com.anji.springbootoauth2demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Description:
 * author: chenqiang
 * date: 2018/6/14 14:11
 */
public interface UserJPA extends JpaRepository<User, String> {
    @Query("SELECT u FROM User u WHERE LOWER(u.username)=LOWER(:username)")
    User findByUsernameCaseInsensitive(@Param("username") String username);
}
