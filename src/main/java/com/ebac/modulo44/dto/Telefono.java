package com.ebac.modulo44.dto;

import lombok.Data;

@Data
public class Telefono {
    private int idTelefono;
    private String tipoTelefono;
    private int lada;
    private String numero;
    private Usuario usuario;
}
