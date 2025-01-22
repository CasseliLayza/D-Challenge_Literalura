package com.backend.challengeliteralura.service;

public interface IConvierteDatosService {

    <T> T obtenerDatos(String json, Class<T> clase);

}
