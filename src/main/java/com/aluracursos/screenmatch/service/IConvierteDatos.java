package com.aluracursos.screenmatch.service;

public interface IConvierteDatos {
    //<T> T = tipos de datos genericos
    <T> T obtenerDatos(String json, Class<T> clase);
}
