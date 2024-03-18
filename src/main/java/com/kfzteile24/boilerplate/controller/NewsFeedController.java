package com.kfzteile24.boilerplate.controller;

import com.kfzteile24.boilerplate.dto.hello.HelloResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created on 03.01.24.
 *
 * a simple controller demostrating how to use some spring features at K24
 *
 * for OpenAPI demos, check here: https://github.com/springdoc/springdoc-openapi-demos/tree/master/springdoc-openapi-spring-boot-2-webmvc
 */
@RestController
@Tag(name="Hello", description = "the most welcoming API")
public class HelloController {

    @GetMapping("/news")
    @Operation(summary = "say hi",
            description = "being polite and smiling are free (as in speech), this end points proves that")
    public ResponseEntity<HelloResponse> sayHello() {
        return ResponseEntity.ok();
    }

}
