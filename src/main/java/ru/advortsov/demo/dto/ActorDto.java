/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2021 VTB Group. All rights reserved.
 */

package ru.advortsov.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * ActorDto.
 *
 * @author Aleksandr_Dvortsov
 */
@Data
@AllArgsConstructor
public class ActorDto {
    private String firstName;
    private String lastName;
    private LocalDateTime update;
}
