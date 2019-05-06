package com.pmt.repository;

import com.pmt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

//    User findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);

    List<User> findByUsernameIn(Collection<String> usernames);
}
