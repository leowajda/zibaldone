package com.tutego.ch_06.advanced;

import com.tutego.ch_06.read.Profile;
import jakarta.persistence.*;

@Entity
@Access(AccessType.FIELD)
public class Unicorn extends AbstractEntity {

    @Embedded
    @AttributeOverrides(
            value = {
                    @AttributeOverride(name = "email", column = @Column(name = "email")),
                    @AttributeOverride(name = "password", column = @Column(name = "password"))
            }
    )
    private LoginCredentials credentials;

    @OneToOne
    @JoinColumn(name = "profile_fk") // loaded eagerly
    private Profile profile;


    @Override
    public String toString() {
        return "Unicorn{" +
                "credentials=" + credentials +
                ", profile=" + profile +
                '}';
    }
}
