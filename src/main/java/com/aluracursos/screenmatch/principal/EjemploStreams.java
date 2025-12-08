package com.aluracursos.screenmatch.principal;

import java.util.Arrays;
import java.util.List;

public class EjemploStreams {
    public void muestraEjemplo(){
        List<String> nombres = Arrays.asList("Brenda","Luis","Maria Fernanda","Eric","Genesys");
        //realizar diferentes funciones con la lista
        nombres.stream()
                //ordenamons
                .sorted()
                //limitar lista
                .limit(4)
                //filtro para encontrar nombre
                .filter(n ->n.startsWith("L"))
                //poner en Mayucula
                .map(n ->n.toUpperCase())
                //imprimir
                .forEach(System.out::println);
    }
}
