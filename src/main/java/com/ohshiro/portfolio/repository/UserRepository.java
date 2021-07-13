package com.ohshiro.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ohshiro.portfolio.model.Userentity;

@Repository
public interface UserRepository extends JpaRepository<Userentity, Long> {

}
