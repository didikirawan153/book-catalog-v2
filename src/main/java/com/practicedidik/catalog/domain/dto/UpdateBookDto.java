package com.practicedidik.catalog.domain.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class UpdateBookDto {
	@NotBlank
	private String bookTitle;

	@JsonProperty(value = "synopsis")
	private String description;
}
