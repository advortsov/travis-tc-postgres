package ru.advortsov.demo.resource;

import static org.jooq.db.Tables.ACTOR;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.jooq.db.tables.records.ActorRecord;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import ru.advortsov.demo.IntegrationTest;
import ru.advortsov.demo.dto.ActorDto;

import java.time.LocalDateTime;
import java.util.List;

class MyResourceTest extends IntegrationTest {

    @Test
    void test1() {

        ActorRecord actorRecord = ctx.newRecord(ACTOR);
        actorRecord.setFirstName("John");
        actorRecord.setLastName("Doe");
        actorRecord.setLastUpdate(LocalDateTime.now());
        actorRecord.store();

        ResponseEntity<List<ActorDto>> response = restTemplate.exchange(
                "/api/actor",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        assertEquals(1, response.getBody().size());
    }
}