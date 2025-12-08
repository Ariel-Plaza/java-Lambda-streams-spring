package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "http://www.omdbapi.com/?t=";
    private final String  API_KEY = "&apikey=9da7ed5e";
    private ConvierteDatos conversor =  new ConvierteDatos();

    public void muestraElMenu(){
        System.out.println("Por favor escribe el nombre de la serie que deseas buscar: ");
        var nombreSerie =teclado.nextLine();

        var json = consumoAPI.obtenerDatos(URL_BASE + nombreSerie.replace(' ', '+')+ API_KEY);
        var datos =  conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datos);
        //Creacion lista con datos temporadas
        List<DatosTemporadas> temporadas = new ArrayList<>();
        //bucle se repite hasta el totalTemporadas
        for (int i = 1; i <= datos.totalDeTemporadas(); i++) {
            //consumo de api, por temporada de cada serie aumenta en cada bucle
            var jsonTemporadas = consumoAPI.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&Season="+ i+ API_KEY );
            //convierte datos de API a datos de la clase temporada
            var datosTemporadas = conversor.obtenerDatos(jsonTemporadas,  DatosTemporadas.class);
            //agrega los datos de la temporada a la lista
            temporadas.add(datosTemporadas);
        }
        //imprime los datos de cada temporada por separado
//        temporadas.forEach(System.out::println);

        //Mostrars solo el titulo de los episodios de las temporadas
        //Itera la lista de la temporadas, para traer los episodios
//        for (int i = 0; i < datos.totalDeTemporadas() ; i++) {
//            List<DatosEpisodio> episodioTemporada = temporadas.get(i).episodios();
//            //Itera lista de episodios y obtener el titulo
//            for (int j = 0; j < episodioTemporada.size(); j++) {
//                System.out.println(episodioTemporada.get(j).titulo());
//
//            }
//        }
        //funcion lambda
        temporadas.forEach(t -> t.episodios().forEach(e-> System.out.println(e.titulo())));
    }
}
