package com.tutego.ch_05.utils;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Map;

@Repository
class LikesInserter {
    private final SimpleJdbcInsert jdbcInsertLikes;

    public LikesInserter(DataSource dataSource) {
        jdbcInsertLikes = new SimpleJdbcInsert(dataSource).withTableName("Likes");
    }

    // KeyHolder, Void, or Number
    public KeyHolder addLike(long liker, long likee) {
        return jdbcInsertLikes.executeAndReturnKeyHolder(Map.of("liker_fk", liker, "likee_fk", likee));
    }

    // number of rows affected by every insert in the batch
    @SuppressWarnings("unchecked")
    public int[] addLikes(Map<String, ?> likes) {
        return jdbcInsertLikes.executeBatch(likes);
    }


}
