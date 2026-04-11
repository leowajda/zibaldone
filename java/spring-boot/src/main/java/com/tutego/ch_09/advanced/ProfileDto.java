package com.tutego.ch_09.advanced;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ProfileDto(
        @Min(1) Long id,
        @NonNull @Length(min = 10, max = 200) String nickname,
        @Past LocalDate birthdate,
        @Positive int maneLength,
        @Min(1) int gender,
        @Min(1) Integer attractedToGender,
        String description,
        @Past LocalDateTime lastSeen
) { }
