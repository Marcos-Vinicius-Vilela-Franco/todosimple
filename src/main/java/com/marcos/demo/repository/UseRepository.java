package com.marcos.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcos.demo.models.User;

@Repository
public interface UseRepository extends JpaRepository<User,Long> {
    
}
