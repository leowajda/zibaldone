package com.tutego.ch_05.utils;

import com.tutego.ch_05.batchOperation.Photo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.Types.BOOLEAN;
import static java.sql.Types.TIMESTAMP;

@Configuration(proxyBeanMethods = false)
public class PhotoMappingSqlQueryConfiguration {

    @Bean
    public MappingSqlQuery<Photo> photoMappingSqlQuery(DataSource dataSource) {
        var sqlQuery = new MappingSqlQuery<Photo>(
                dataSource,
                "SELECT id, profile_fk, name, is_profile_photo, created FROM Photo WHERE is_profile_photo = ? AND created > ?"
        ) {
            @Override
            protected Photo mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Photo(
                        rs.getLong("profile_fk"),
                        rs.getString("name"),
                        rs.getBoolean("is_profile_photo"),
                        rs.getTimestamp("created").toLocalDateTime()
                );
            }
        };

        // pretty bad interface, even with the MappingSqlQuery<T> the interface is not typed
        sqlQuery.declareParameter(new SqlParameter("is_profile_photo", BOOLEAN));
        sqlQuery.declareParameter(new SqlParameter("created", TIMESTAMP));
        return sqlQuery;
    }


}
