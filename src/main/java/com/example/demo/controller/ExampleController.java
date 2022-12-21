package com.example.demo.controller;

import com.example.demo.dto.ExampleDto;
import com.example.demo.service.ExampleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@AllArgsConstructor
@Slf4j
public class ExampleController {

    private final ExampleService exampleService;

    @GetMapping
    public ExampleDto findByName(@RequestParam String name) {
        return exampleService.getByName(name);
    }

    @PostMapping
    public void save(@RequestBody ExampleDto dto) {
        exampleService.save(dto);
    }
}
