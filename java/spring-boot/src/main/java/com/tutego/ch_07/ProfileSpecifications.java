package com.tutego.ch_07;

import jakarta.persistence.criteria.Expression;
import org.springframework.data.jpa.domain.Specification;

public class ProfileSpecifications {

    // a limited version of doobie fragments (only covers the use case for criteria)
    public static final Specification<Profile> longMane = (root, query, builder) ->
            builder.greaterThanOrEqualTo(root.get("maneLength"), "10");

    public static final Specification<Profile> nameContainsFat = (root, query, builder) -> {
        Expression<String> nickname = root.get("nickname");
        Expression<String> lowerName = builder.lower(nickname);
        return builder.like(lowerName, "%fat%");
    };

    public static Specification<Profile> longMane(int length) {
        return (root, query, builder) ->
                builder.greaterThanOrEqualTo(root.get("maneLength"), (short) length);
    }

}
