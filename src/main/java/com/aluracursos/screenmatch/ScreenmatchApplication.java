package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.principal.Principal;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Principal principal = new Principal();
        principal.muestraElMenu();

////        System.out.println("Prueba desde Spring");
//        var consumoAPI = new ConsumoAPI();
//        var json = consumoAPI.obtenerDatos("http://www.omdbapi.com/?t=game+of+thrones&apikey=9da7ed5e");
////        var json = consumoAPI.obtenerDatos("https://coffee.alexflipnote.dev/random.json");
//        System.out.println(json);
//
//        //Serie
//        ConvierteDatos conversor = new ConvierteDatos();
//        var datos = conversor.obtenerDatos(json, DatosSerie.class);
//        System.out.println(datos);

//        //Temporada
//        //Creacion lista con datos temporadas
//        List<DatosTemporadas> temporadas = new ArrayList<>();
//
//        //bucle se repite hasta el totalTemporadas
//        for (int i = 1; i < datos.totalDeTemporadas(); i++) {
//            //consumo de api, por temporada de cada serie aumenta en cada bucle
//            var jsonTemporadas = consumoAPI.obtenerDatos("http://www.omdbapi.com/?t=Young+Sheldon&Season="+i+"&apikey=9da7ed5e");
//            //convierte datos de API a datos de la clase temporada
//            var datosTemporadas = conversor.obtenerDatos(jsonTemporadas,  DatosTemporadas.class);
//            //agrega los datos de la temporada a la lista
//            temporadas.add(datosTemporadas);
//        }
//        //imprime los datos de cada temporada por separado
//        temporadas.forEach(System.out::println);

//
//        //Episodios
//        var jsonEpisodio = consumoAPI.obtenerDatos("http://www.omdbapi.com/?t=game+of+thrones&Season=1&episode=1&apikey=9da7ed5e");
//        var datosEpisodio = conversor.obtenerDatos(jsonEpisodio, DatosEpisodio.class);
//        System.out.println(datosEpisodio);



    }
}
