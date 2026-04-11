package com.tutego.ch_09.advanced;

import jakarta.validation.Valid;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdvancedController {

    private final ProfileMapper profileMapper;

    public AdvancedController(ProfileMapper profileMapper, ConversionService conversionService) {
        this.profileMapper = profileMapper;
        // profileMapper.convert(profile)
        // conversionService.convert(profile, ProfileDto.class);
    }

    @PutMapping("validate") // in case validation were to fail, an exception would be thrown
    public ResponseEntity<?> update(@Valid /* will not work on Optional<T> */ @RequestBody ProfileDto dto) {
        return ResponseEntity.accepted().body(dto);
    }

}
