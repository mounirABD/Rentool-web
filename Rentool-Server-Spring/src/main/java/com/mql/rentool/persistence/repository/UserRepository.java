package com.mql.rentool.persistence.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mql.rentool.persistence.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
