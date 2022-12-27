package com.example.demo;

import com.example.demo.dto.ExampleDto;
import lombok.SneakyThrows;
import org.postgresql.util.PGobject;
import org.springframework.aot.hint.ExecutableMode;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

@SpringBootApplication
@ImportRuntimeHints(DemoApplication.DemoApplicationRuntimeHints.class)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    static class DemoApplicationRuntimeHints implements RuntimeHintsRegistrar {

        @SneakyThrows
        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            hints.reflection()
                    .registerConstructor(PGobject.class.getDeclaredConstructor(), ExecutableMode.INVOKE)
                    .registerConstructor(ExampleDto.ExampleDtoBuilder.class.getDeclaredConstructor(), ExecutableMode.INVOKE)
                    .registerMethod(
                            ExampleDto.ExampleDtoBuilder.class.getMethod("build"), ExecutableMode.INVOKE);
        }
    }
}
