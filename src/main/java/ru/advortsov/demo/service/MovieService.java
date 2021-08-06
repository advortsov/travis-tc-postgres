/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2021 VTB Group. All rights reserved.
 */

package ru.advortsov.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.advortsov.demo.dto.FilmDto;
import ru.advortsov.demo.repository.MovieRepository;

import java.util.List;

/**
 * MovieService.
 *
 * @author Aleksandr_Dvortsov
 */
@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<FilmDto> get() {
        return movieRepository.getAll();
    }
}
