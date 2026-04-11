package com.tutego.ch_07;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest // H2 in classpath -> in memory DB instance is used for testing
class ProfileJpaRepositoryTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager em;

    @Autowired
    private ProfileRepository profiles;

    @Test
    void datasource_jdbctemplate_entitymanager_repository_not_null() {
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(em).isNotNull();
        assertThat(profiles).isNotNull();
    }
}
