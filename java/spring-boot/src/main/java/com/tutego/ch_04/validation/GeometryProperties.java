package com.tutego.ch_04.validation;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "geometry")
public record GeometryProperties(@NotNull Box box, @NotNull Circle circle) {
    public record Box(@Min(50) @Max(1000) int width, @Min(50) @Max(600) int height) { }
    public record Circle(@Min(10) @Max(1000) int radius) { /* conflicts with org.springframework.boot.context.properties.* */ }
}
