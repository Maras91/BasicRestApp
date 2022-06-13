package com.empik.repository;

import com.empik.entity.QueryCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QueryCountRepository extends JpaRepository<QueryCount, String> {
    Optional<QueryCount> findByLogin(String login);
}
