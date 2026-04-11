package com.tutego.ch_06.advanced;

import com.tutego.ch_06.read.Profile;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Optional;

@ShellComponent
public class AdvancedShellComponent {

    private static final Logger logger = LoggerFactory.getLogger(AdvancedShellComponent.class);
    private final EntityManager entityManager;

    public AdvancedShellComponent(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @ShellMethod
    public void findUnicorn(long id) {
        var res = Optional.ofNullable(entityManager.find(Unicorn.class, id))
                .map(String::valueOf)
                .orElse("not present");

        logger.info("unicorn: {}", res);
    }

    @ShellMethod
    public void findMales() {
        // JPQL can navigate through associative elements
        entityManager.createQuery("SELECT u FROM Unicorn u WHERE u.profile.gender = MALE", Unicorn.class)
                .getResultList()
                .forEach(unicorn -> logger.info(unicorn.toString()));
    }

    @ShellMethod("Display all photos of a given profile by ID")
    public void photos(long id) {
        Optional.ofNullable(entityManager.find(Profile.class, id))
                .ifPresent(profile -> profile.getPhotos().forEach(photo -> logger.info(photo.toString())));
    }

}
