/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2021 VTB Group. All rights reserved.
 */

package ru.advortsov.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.advortsov.demo.dto.ActorDto;
import ru.advortsov.demo.repository.ActorRepository;

import java.util.List;

/**
 * ActorService.
 *
 * @author Aleksandr_Dvortsov
 */
@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorRepository actorRepository;

    public List<ActorDto> getAll() {
        return actorRepository.getAll();
    }
}
