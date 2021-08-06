

package ru.advortsov.demo;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.Source;
import org.jooq.impl.DSL;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.jdbc.ContainerDatabaseDriver;
import ru.advortsov.demo.config.TestJooqConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * TestContainersRunner.
 *
 * @author advortsov
 */
@Slf4j
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ContextConfiguration(classes = {DemoApplication.class, TestJooqConfiguration.class})
public abstract class TestContainersRunner {

    public static Connection connection;
    public static DSLContext ctx;


    static {
        Properties properties = new Properties();
        properties.setProperty("username", "postgres");
        properties.setProperty("password", "postgres");

        log.info("Connecting");
        try {
            connection = new ContainerDatabaseDriver().connect(
                    "jdbc:tc:postgresql:13:///sakila?TC_TMPFS=/testtmpfs:rw",
                    properties
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ctx = DSL.using(connection, SQLDialect.POSTGRES);

        // Use JDBC directly instead of jOOQ to avoid DEBUG logging all of this
        try (Statement s = connection.createStatement()) {
            log.info("Setting up database");
            s.execute(Source.of(TestContainersRunner.class.getResourceAsStream("/postgres-sakila-schema.sql")).readString());

            log.info("Inserting data to database");
//            s.execute(Source.of(TestContainersRunner.class.getResourceAsStream("/postgres-sakila-insert-data.sql")).readString());

            log.info("Finished setup");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
