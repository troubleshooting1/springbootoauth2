package com.anji.springbootoauth2demo.jpa;

import com.anji.springbootoauth2demo.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description:
 * author: chenqiang
 * date: 2018/6/14 14:14
 */
public interface AuthorityJPA extends JpaRepository<Authority, String> {
}
