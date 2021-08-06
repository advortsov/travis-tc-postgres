

package ru.advortsov.demo.resource;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.advortsov.demo.dto.ActorDto;
import ru.advortsov.demo.dto.FilmDto;
import ru.advortsov.demo.service.ActorService;
import ru.advortsov.demo.service.MovieService;

import java.util.List;

/**
 * MyResource.
 *
 * @author Aleksandr_Dvortsov
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MyResource {

    private final MovieService movieService;
    private final ActorService actorService;

    @GetMapping("/test/")
    @ResponseStatus(HttpStatus.OK)
    public List<FilmDto> test() {
        return movieService.get();
    }


    @GetMapping("/actor")
    @ResponseStatus(HttpStatus.OK)
    public List<ActorDto> findAll() {
        return actorService.getAll();
    }

}
