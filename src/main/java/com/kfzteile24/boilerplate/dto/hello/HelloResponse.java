package com.kfzteile24.boilerplate.dto.hello;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created on 03.01.24.
 */
@Getter
@Setter
@AllArgsConstructor
public class HelloResponse {

    public int age;
    public BigDecimal price;

}
