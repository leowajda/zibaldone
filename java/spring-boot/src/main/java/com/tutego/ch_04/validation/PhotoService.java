package com.tutego.ch_04.validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class PhotoService {

    private static final Logger logger = LoggerFactory.getLogger(PhotoService.class);

    public void checkValidity(@Valid Photo photo) {
        logger.info("proxy has successfully validated photo: {}", photo);
    }

    public @NotEmpty String invalidOutput() {
        return "";
    }

}
