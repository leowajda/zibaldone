package com.tutego.ch_02.autoConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(
        scanBasePackageClasses = AutoConfigurationModule.class,
        exclude = { // selectively exclude some of the autoconfigured beans (improves start-up time)
                DataSourceAutoConfiguration.class,
                DataSourceTransactionManagerAutoConfiguration.class,
                HibernateJpaAutoConfiguration.class
        }
)
public class AutoConfigurationApplication {

    public static void main(String... args) {
        SpringApplication.run(AutoConfigurationApplication.class, args);
    }

}
