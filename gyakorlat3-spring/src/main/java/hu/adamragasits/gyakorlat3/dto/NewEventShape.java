package hu.adamragasits.gyakorlat3.dto;

import jakarta.validation.constraints.NotNull;

public record NewEventShape(
		String title, 
		String description
) {}