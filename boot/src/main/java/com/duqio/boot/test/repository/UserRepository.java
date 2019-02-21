package com.duqio.boot.test.repository;

import org.springframework.stereotype.Repository;

import com.duqio.boot.orm.jpa.repository.BaseRepository;
import com.duqio.boot.test.entity.User;

@Repository
public interface UserRepository extends BaseRepository<User, Integer> {

}
