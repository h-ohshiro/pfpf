package com.ohshiro.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ohshiro.portfolio.model.Todoentity;

@Repository

public interface TodoRepository extends JpaRepository<Todoentity, Long> {

}
