package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "example")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ExampleEntity {

    @Id
    @GeneratedValue(generator = "example_id_seq")
    private int id;

    private String name;

    private String surname;
}
