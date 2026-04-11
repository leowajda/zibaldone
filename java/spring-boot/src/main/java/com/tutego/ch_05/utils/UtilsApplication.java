package com.tutego.ch_05.utils;

import com.tutego.ch_05.batchOperation.Photo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.object.MappingSqlQuery;

import java.time.LocalDate;

@SpringBootApplication
public class UtilsApplication {

    private static final Logger logger = LoggerFactory.getLogger(UtilsApplication.class);

    public UtilsApplication(MappingSqlQuery<Photo> mappingSqlQuery) {
        mappingSqlQuery.execute(false, LocalDate.MIN).stream().map(Photo::toString).forEach(logger::info);
    }

    public static void main(String... args) {
        SpringApplication.run(UtilsApplication.class, args);
    }

}
