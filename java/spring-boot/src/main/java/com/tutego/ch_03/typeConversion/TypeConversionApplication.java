package com.tutego.ch_03.typeConversion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Locale;

@ShellComponent
@SpringBootApplication(scanBasePackageClasses = TypeConversionModule.class)
public class TypeConversionApplication {

    private static final Logger logger = LoggerFactory.getLogger(TypeConversionApplication.class);

    public static void main(String... args) {
        SpringApplication.run(TypeConversionApplication.class, args);

        var converter = ApplicationConversionService.getSharedInstance();
        LocaleContextHolder.setLocale(Locale.GERMANY);
        logger.info(converter.convert(LocalDate.now(), String.class));

        LocaleContextHolder.setLocale(Locale.FRANCE);
        logger.info(converter.convert(LocalDate.now(), String.class));
    }

    @ShellMethod("Display if a path exists")
    public String exists(Path path) {
        boolean exists = Files.exists(path);
        return String.format("Path to '%s' %s exist", path, exists ? "does" : "doesn't");
    }

}
