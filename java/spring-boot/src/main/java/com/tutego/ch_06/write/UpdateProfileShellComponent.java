package com.tutego.ch_06.write;

import com.tutego.ch_06.read.Profile;
import jakarta.persistence.EntityManager;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@ShellComponent
public class UpdateProfileShellComponent {

    private final EntityManager entityManager;

    public UpdateProfileShellComponent(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @ShellMethod("Set mane length of a given profile")
    public void updateManeLength(long id, short maneLength) {
        // Dirty checking is a transaction feature. No transaction = no automatic persistence of changes
        Optional.ofNullable(entityManager.find(Profile.class, id))
                .ifPresent(p -> p.setManeLength(maneLength));
    }
}