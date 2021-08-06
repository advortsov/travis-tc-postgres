package ru.advortsov.demo.config;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import ru.advortsov.demo.TestContainersRunner;

/**
 * TestJooqConfiguration.
 *
 * @author Aleksandr_Dvortsov
 */
@TestConfiguration
public class TestJooqConfiguration {

    @Bean
    @Primary
    public DSLContext testDsl() {
        return new DefaultDSLContext(TestContainersRunner.connection, SQLDialect.POSTGRES);
    }

}