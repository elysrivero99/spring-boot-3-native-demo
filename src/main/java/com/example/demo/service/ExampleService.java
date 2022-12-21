package com.example.demo.service;

import com.example.demo.dto.ExampleDto;
import com.example.demo.entity.ExampleEntity;
import com.example.demo.repository.EntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class ExampleService {

    private final EntityRepository entityRepository;

    public void save(ExampleDto dto) {
        final var exampleEntity = this.toEntity(dto);
        entityRepository.save(exampleEntity);
    }

    public ExampleDto getByName(String name) {
        return entityRepository.findByName(name)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Entity not found"));
    }

    private ExampleDto toDto(ExampleEntity entity) {
        return ExampleDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .build();
    }

    private ExampleEntity toEntity(ExampleDto dto) {
        return ExampleEntity.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .build();
    }

}
