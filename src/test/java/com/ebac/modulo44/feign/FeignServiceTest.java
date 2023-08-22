package com.ebac.modulo44.feign;

import com.ebac.modulo44.dto.ResponseWrapper;
import com.ebac.modulo44.dto.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
class FeignServiceTest {

    public static FeignService feignService;

    @BeforeAll
    static void setUp() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.ebac.modulo44.feign");
        context.refresh();

        FeignApiClient feignApiClient = (FeignApiClient) context.getBean("feignApiClient");
        String apiUrl = (String) context.getBean("apiUrl");

        feignService = new FeignService(feignApiClient, apiUrl);
    }

    @Test
    public void testGetUsers() {
        feignService.getUsers().getResponseEntity().getBody().forEach(System.out::println);
    }

    @Test
    public void testGetUserById() {
        Usuario usuario = feignService.getUserById(3).getResponseEntity().getBody();
        log.info("Usuario: {}", usuario);
    }

    @Test
    public void testCreateUser() {
        Usuario usuario = Usuario.builder()
                .nombre("Esteban3")
                .edad(28)
                .build();
        ResponseWrapper<Usuario> responseWrapper = feignService.createUser(usuario);
        log.info("Usuario creado: {}", responseWrapper.getResponseEntity().getBody());
    }

    @Test
    public void testUpdateUserById() {
        Usuario usuario = Usuario.builder()
                .nombre("Casimiro")
                .edad(20)
                .build();
        Usuario usuarioActualizado = feignService.updateUser(20, usuario).getResponseEntity().getBody();
        log.info("Usuario actualizado: {}", usuarioActualizado);
    }

    @Test
    public void testDeleteUserById() {
        int id = 22;
        feignService.deleteUser(id);
        log.info("Usuario con id {} fue eliminado", id);
    }
}