package com.ebac.modulo44.feign;

import com.ebac.modulo44.dto.ResponseWrapper;
import com.ebac.modulo44.dto.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class FeignService {

    public final FeignApiClient feignApiClient;
    public final String apiUrl;

    @Autowired
    public FeignService(FeignApiClient FeignApiClient, String apiUrl) {
        this.feignApiClient = FeignApiClient;
        this.apiUrl = apiUrl;
    }

    public ResponseWrapper<List<Usuario>> getUsers() {
        log.info("Obteniendo usuarios desde la api {}", apiUrl);
        return feignApiClient.getUsers();
    }

    public ResponseWrapper<Usuario> getUserById(int id) {
        log.info("Obteniendo usuario con id {}", id);
        // Tarea agregar validaciones pertinentes
        return feignApiClient.getUserById(id);
    }

    public ResponseWrapper<Usuario> createUser(Usuario user) {
        log.info("Creando usuario {}", user);
        return feignApiClient.createUser(user);
    }

    public ResponseWrapper<Usuario> updateUser(int id, Usuario user) {
        log.info("Actualizando usuario {}", user.getNombre());
        return feignApiClient.updateUser(user, id);
    }

    public void deleteUser(int id) {
        log.info("Eliminando usuario con id {}", id);
        feignApiClient.deleteUser(id);
    }
}
