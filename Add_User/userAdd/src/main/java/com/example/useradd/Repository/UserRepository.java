package com.example.useradd.Repository;

import com.example.useradd.Entity.Users;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
    boolean existsByFirstnameAndLastname(String firstname, String lastname);
    boolean existsById(Integer id);
}
