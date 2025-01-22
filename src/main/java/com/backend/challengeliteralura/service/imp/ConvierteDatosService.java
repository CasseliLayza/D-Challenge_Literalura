package com.backend.challengeliteralura.service.imp;

import com.backend.challengeliteralura.service.IConvierteDatosService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatosService implements IConvierteDatosService {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return mapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
