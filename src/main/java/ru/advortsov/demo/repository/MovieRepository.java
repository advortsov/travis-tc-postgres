/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2021 VTB Group. All rights reserved.
 */

package ru.advortsov.demo.repository;


import static org.jooq.db.Tables.FILM;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import ru.advortsov.demo.dto.FilmDto;

import java.util.List;

/**
 * MovieRepository.
 *
 * @author Aleksandr_Dvortsov
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MovieRepository {

    private final DSLContext ctx;

    public List<FilmDto> getAll() {
        // Get films by title, and their actors and categories as nested collections, as well as
        // all the customers that have rented the film
        var result = ctx
                .select(FILM.TITLE.as("title"))
                .from(FILM)
                .where(FILM.TITLE.like("A%"))
                .orderBy(FILM.TITLE)
                .limit(5)
                .fetch()
                .map(record -> new FilmDto(record.get(FILM.TITLE)));

        System.out.println(result);
        return result;
    }
}
