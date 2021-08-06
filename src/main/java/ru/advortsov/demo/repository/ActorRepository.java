/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2021 VTB Group. All rights reserved.
 */

package ru.advortsov.demo.repository;

import static org.jooq.db.Tables.ACTOR;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.advortsov.demo.dto.ActorDto;

import java.util.List;

/**
 * ActorRepository.
 *
 * @author Aleksandr_Dvortsov
 */
@Repository
@RequiredArgsConstructor
public class ActorRepository {

    private final DSLContext ctx;

    public List<ActorDto> getAll() {
        return ctx
                .select(ACTOR.FIRST_NAME, ACTOR.LAST_NAME, ACTOR.LAST_UPDATE)
                .from(ACTOR)
                .fetch()
                .map(record -> new ActorDto(
                                record.get(ACTOR.FIRST_NAME),
                                record.get(ACTOR.LAST_NAME),
                                record.get(ACTOR.LAST_UPDATE)
                        )
                );
    }
}
