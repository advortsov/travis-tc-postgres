

package ru.advortsov.demo;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.advortsov.demo.repository.ActorRepository;
import ru.advortsov.demo.repository.MovieRepository;

/**
 * ru.vtb.omni.oac.IntegrationTest.
 *
 * @author Aleksandr_Dvortsov
 */
public abstract class IntegrationTest extends TestContainersRunner {

    @Autowired
    protected TestRestTemplate restTemplate;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected ActorRepository actorRepository;

    @Autowired
    protected MovieRepository movieRepository;

    protected <R> R invokeGetApi(Class<R> resultType, String url, HttpStatus checkStatus, Object... urlParams) {
        ResponseEntity<R> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(null, null), resultType, urlParams);
        assertEquals(checkStatus, response.getStatusCode());
        return response.getBody();
    }

    protected <R> R invokeGetApi(Class<R> resultType, String url, HttpStatus checkStatus, HttpHeaders headers, Object... urlParams) {
        ResponseEntity<R> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(null, headers), resultType, urlParams);
        assertEquals(checkStatus, response.getStatusCode());
        return response.getBody();
    }

    protected <R, T extends ParameterizedTypeReference<R>> R invokeGetApi(T resultType, String url, HttpStatus checkStatus, Object... urlParams) {
        ResponseEntity<R> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(null, null), resultType, urlParams);
        assertEquals(checkStatus, response.getStatusCode());
        return response.getBody();
    }

    protected <R, T extends ParameterizedTypeReference<R>> R invokeGetApi(T resultType, String url, HttpStatus checkStatus, HttpHeaders headers, Object... urlParams) {
        ResponseEntity<R> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(null, headers), resultType, urlParams);
        assertEquals(checkStatus, response.getStatusCode());
        return response.getBody();
    }

    protected <R, D> R invokePutApi(Class<R> resultType, String url, HttpStatus checkStatus, D dto, Object... urlParams) {
        ResponseEntity<R> response = restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(dto, null), resultType, urlParams);
        assertEquals(checkStatus, response.getStatusCode());
        return response.getBody();
    }

    protected <R, D> R invokePostApi(Class<R> resultType, String url, HttpStatus checkStatus, D dto, Object... urlParams) {
        ResponseEntity<R> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(dto, null), resultType, urlParams);
        assertEquals(checkStatus, response.getStatusCode());
        return response.getBody();
    }

    protected <R, D> R invokeDeleteApi(Class<R> resultType, String url, HttpStatus checkStatus, D dto, Object... urlParams) {
        ResponseEntity<R> response = restTemplate.exchange(url, HttpMethod.DELETE, new HttpEntity<>(dto, null), resultType, urlParams);
        assertEquals(checkStatus, response.getStatusCode());
        return response.getBody();
    }

    protected <R, D> R invokeDeleteApi(ParameterizedTypeReference<R> responseType, String url, HttpStatus checkStatus, D dto, Object... urlParams) {
        ResponseEntity<R> response = restTemplate.exchange(url, HttpMethod.DELETE, new HttpEntity<>(dto, null), responseType, urlParams);
        assertEquals(checkStatus, response.getStatusCode());
        return response.getBody();
    }

    protected <R, D> R invokePostApi(ParameterizedTypeReference<R> responseType, String url, HttpStatus checkStatus, D dto, Object... urlParams) {
        ResponseEntity<R> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(dto, null), responseType, urlParams);
        assertEquals(checkStatus, response.getStatusCode());
        return response.getBody();
    }

    protected <R, T extends ParameterizedTypeReference<R>, D> R invokePutApi(T resultType, String url, HttpStatus checkStatus, D dto, Object... urlParams) {
        ResponseEntity<R> response = restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(dto, null), resultType, urlParams);
        assertEquals(checkStatus, response.getStatusCode());
        return response.getBody();
    }
}
