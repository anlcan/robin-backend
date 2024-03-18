package com.kfzteile24.boilerplate.controller;

import com.kfzteile24.boilerplate.dto.hello.HelloRequest;
import com.kfzteile24.boilerplate.dto.hello.HelloResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import java.math.BigDecimal;

/**
 * Created on 03.01.24.
 *
 * a simple controller demostrating how to use some spring features at K24
 * TODO: remove this class once in your implementations
 *
 * for OpenAPI demos, check here: https://github.com/springdoc/springdoc-openapi-demos/tree/master/springdoc-openapi-spring-boot-2-webmvc
 */
@RestController
@Tag(name="Hello", description = "the most welcoming API")
public class HelloController {

    @GetMapping("/hello")
    @Operation(summary = "say hi",
            description = "being polite and smiling are free (as in speech), this end points proves that")
    public ResponseEntity<HelloResponse> sayHello() {
        return ResponseEntity.ok(new HelloResponse(12, BigDecimal.TEN));
    }

    @PostMapping("/hello")
    @Operation(summary = "say hi if requested",
            description = "The same endpoint with the same name doing something else for POST method")
    public ResponseEntity<HelloResponse> responseHello(@Valid @RequestBody HelloRequest request) {


        final HelloResponse body = new HelloResponse(request.getSalesChannel().equals("www-k24-de") ? 1 : 2,
                BigDecimal.TEN);
        return ResponseEntity.ok(body);
    }
}
