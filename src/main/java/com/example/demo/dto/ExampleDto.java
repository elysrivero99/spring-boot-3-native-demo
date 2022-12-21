package com.example.demo.dto;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class ExampleDto {
    Integer id;
    String name;
    String surname;

}
