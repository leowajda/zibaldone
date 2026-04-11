package com.tutego.ch_04.validation;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

public record Photo(

        @Min(1)
        Long id,

        @Min(1)
        long profile,

        @NotNull
        @Pattern(regexp = "[\\w_-]{1,200}")
        String name,

        boolean isProfilePhoto,

        @NotNull
        @Past
        LocalDateTime created
) {
}

