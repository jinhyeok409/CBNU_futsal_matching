package com.project.cbnu.repository;

import com.project.cbnu.entity.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ListRepository extends JpaRepository<ListEntity, Integer> {
    // Game으로 Find
    Optional<ListEntity> findByGamelist (Integer Gamelist);


}
