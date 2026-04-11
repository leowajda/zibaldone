package com.tutego.ch_06.advanced;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

// the @Entity @Access policy cascades to @MappedSuperclass types as well
// similar to AbstractPersistable type (the ID generation policy is not that flexible there)
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
