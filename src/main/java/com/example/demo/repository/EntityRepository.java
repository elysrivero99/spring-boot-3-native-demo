package com.example.demo.repository;

import com.example.demo.entity.ExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntityRepository extends JpaRepository<ExampleEntity, Integer> {

    Optional<ExampleEntity> findByName(String name);

}
