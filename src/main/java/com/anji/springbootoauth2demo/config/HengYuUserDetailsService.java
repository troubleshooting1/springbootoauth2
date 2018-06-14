package com.anji.springbootoauth2demo.config;

import com.anji.springbootoauth2demo.entity.Authority;
import com.anji.springbootoauth2demo.entity.User;
import com.anji.springbootoauth2demo.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Description:
 * author: chenqiang
 * date: 2018/6/14 14:19
 */
@Component("userDetailService")
public class HengYuUserDetailsService implements UserDetailsService {
    @Autowired
    private UserJPA userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {
        String lowercaseLogin=login.toLowerCase();

        User userFromDatabase=userRepository.findByUsernameCaseInsensitive(lowercaseLogin);

        if(userFromDatabase==null){
            throw new UsernameNotFoundException("User "+lowercaseLogin+" was not found in the database");
        }

        Collection<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        for(Authority authority:userFromDatabase.getAuthorities()){
            GrantedAuthority grantedAuthority=new SimpleGrantedAuthority(authority.getName());
            grantedAuthorities.add(grantedAuthority);
        }

        //返回一个SpringSecurity需要用到的用户对象
        return new org.springframework.security.core.userdetails.User(
                userFromDatabase.getUsername(),
                userFromDatabase.getPassword(),
                grantedAuthorities);
    }
}
