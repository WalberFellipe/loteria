package com.walber.loteria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walber.loteria.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
