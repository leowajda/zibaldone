package com.tutego.ch_06.advanced;

import com.tutego.ch_06.read.Profile;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Access(AccessType.FIELD)
public class Photo extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "profile_fk")
    private Profile profile;

    private String name;

    @Column(name = "is_profile_photo")
    private boolean isProfilePhoto;

    private LocalDateTime created;

    @Override
    public String toString() {
        return "Photo{" +
                "profile=" + profile +
                ", name='" + name + '\'' +
                ", isProfilePhoto=" + isProfilePhoto +
                ", created=" + created +
                '}';
    }
}
