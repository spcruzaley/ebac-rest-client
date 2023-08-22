package com.ebac.modulo44.resttemplate;

import com.ebac.modulo44.dto.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class RestTemplateClient {

    private final RestTemplate restTemplate;

    public RestTemplateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getUsers() {
        String url = "http://localhost:8080/usuarios";

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        if(!responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            log.error("Error al invocar la url {}", url);
            return "";
        }

        return responseEntity.getBody();
    }

    public String getUserById(long id) {
        String url = "http://localhost:8080/usuarios/" + id;

        // Codigo faltante

        return "";
    }

    public String createUser(Usuario usuario) {
        String url = "http://localhost:8080/usuarios";

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, usuario, String.class);
        if(!responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            log.error("Error al invocar la url {}", url);
            return "";
        }

        return responseEntity.getBody();
    }

    public String updateUserById(Usuario usuario, long id) {
        String url = "http://localhost:8080/usuarios/" + id;

        restTemplate.put(url, usuario);

        return "";
    }

    public String deleteUserById(long id) {
        String url = "http://localhost:8080/usuarios/" + id;

        restTemplate.delete(url);

        return "";
    }
}
