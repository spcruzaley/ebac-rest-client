package com.ebac.modulo44.resttemplate;

import com.ebac.modulo44.dto.Usuario;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

@Slf4j
class RestTemplateServiceTest {

    private static RestTemplateService restTemplateService;

    @BeforeAll
    static void init() {
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateClient restTemplateClient = new RestTemplateClient(restTemplate);
        ObjectMapper objectMapper = new ObjectMapper();
        restTemplateService = new RestTemplateService(restTemplateClient, objectMapper);
    }

    @Test
    public void testGetUsers() throws JsonProcessingException {
        restTemplateService.getUsers();
    }

    @Test
    public void testGetUserById() throws JsonProcessingException {
        //Agregar implementacion en clase RestTemplateClient
        restTemplateService.getUserById(2);
    }

    @Test
    public void testCreateUser() {
        Usuario usuario = Usuario.builder()
                .nombre("Ramon")
                .edad(32)
                .build();

        restTemplateService.createUser(usuario);
    }

    @Test
    public void testUpdateUserById() {
        int id = 18;
        Usuario usuario = Usuario.builder()
                .idUsuario(id)
                .nombre("Ramona")
                .edad(40)
                .build();

        restTemplateService.updateUser(usuario, id);
    }

    @Test
    public void testDeleteUserById() {
        restTemplateService.deleteUser(18);
    }
}