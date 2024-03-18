package com.kfzteile24.boilerplate.dto.hello;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

/**
 * Created on 03.01.24.
 *
 *
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HelloRequest {

    @NotBlank(message ="Sales Channel identifier is mandatory")
    @JsonProperty("sales_channel")
    private String salesChannel;
}
