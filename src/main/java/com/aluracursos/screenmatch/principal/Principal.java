package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.model.Episodio;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

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
//        temporadas.forEach(t -> t.episodios().forEach(e-> System.out.println(e.titulo())));

        //Convertir toda la informacion a una lista del tipo DatosEpisodio
        //Crea variable datosEpisodios que guarda lista de episodios, convierte lista temporadas(tiene Lista<DatosEpisodio>
        // en un stream
//        List<DatosEpisodio> datosEpisodios = temporadas.stream()
//                //t es un 'DatosTemporadas' // t.episodios() metodo retorna List<DatosEpisodio>
//                .flatMap(t -> t.episodios()
//                        //convierte lista en 'Steam<DatosEpisodio>'
//                        .stream())
//                //flatMap junto todos los stream
//                //Guarda en una lista
//                .collect(Collectors.toList());
//
//        //Top 5 episodios
//        System.out.println("TOP 5");
//        datosEpisodios.stream()
//                //filtra por evaluacion que sea diferenta a N/A
//                .filter(e ->!e.evaluacion().equalsIgnoreCase("N/A"))
//                .peek(e -> System.out.println("Primer filtro (N/A)" + e))
//                //ordena y compara cada una de las evaluaciones de los episodios  y los da vuelta de Mayor a Menor
//                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
//                .peek(e -> System.out.println("Segundo filtro ordenacion (M>m)" + e))
//                .map(e -> e.titulo().toUpperCase())
//                .peek(e -> System.out.println("Tercer filtro (m>M)" + e))
//
//                //limita a 5 elementos
//                .limit(5)
//                //en un bucle los va imprimiendo.
//                .forEach(System.out::println);
//
//
        //Convirtienedo los datos a una lista del tipo episodio
        //Variable en base a Episodio que pone en stream temporadas
        List<Episodio> episodios = temporadas.stream()
                //obtiene de datos temporadas los episodios y los pone en stream
                .flatMap(t -> t.episodios().stream()
                        //mapea cada episodio y crea un nuevo dato numero episodio que corresponde a la temporada
                      //agrega los datos del episodio: titulo, n episopdio, eval, fecha lanzamiento
                        .map(d -> new Episodio(t.numero(),d)))
                //convierte en una lista
                .collect(Collectors.toList());

        //muestra la lista
//        System.out.println("*** Lista episodios ***");
//        episodios.forEach(System.out::println);

        //Busqueda de episodios a partir de x año
//        System.out.println("Por favor indica el año a partir del cual deseas ver los episodios");
//        var fecha = teclado.nextInt();
//        teclado.nextLine();
//
//        //Formateador fecha
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        //fecha de busqueda parte desde el dia y mes 1
//        LocalDate fechaBusqueda = LocalDate.of(fecha, 1,1);
////        episodios.stream()
////                //filtra episodio por fecha de lanzamiento que no sea nula y que muestre los que estan despues fecha busqueda
////                .filter(e -> e.getFechaDeLanzamiento() != null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
////                //bucle para imprimir los episodios
////                .forEach(e -> System.out.println(
////                        "Temporada " + e.getTemporada() +
////                                "Episodio " + e.getTitulo() +
////                                //format da formato de fecha
////                                "Fecha de Lanzamiento " + e.getFechaDeLanzamiento().format(dtf)
//                ));

//        //Busca episodios por pedazo del titulo
//        System.out.println("Ingresa el titulo del episodio que desea ver: ");
//        var pedazoTitulo = teclado.nextLine();
//        Optional<Episodio> episodioBuscado = episodios.stream()
//                .filter(e -> e.getTitulo().toUpperCase().contains(pedazoTitulo.toUpperCase()))
//                .findFirst();
//        if(episodioBuscado.isPresent()){
//            System.out.println("Episodio encontrado");
//            System.out.println("Los datos son: " + episodioBuscado.get());
//        }else{
//            System.out.println("Episodio no encontrado");
//        }

        //analisiss de datos

        Map<Integer, Double> evaluacionesPorTemporada = episodios.stream()
                .filter(e ->e.getEvaluacion() > 0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada, Collectors.averagingDouble(Episodio::getEvaluacion)));
        System.out.println(evaluacionesPorTemporada);
//permite generar de forma prestablecida estadisticas
        DoubleSummaryStatistics est = episodios.stream()
                .filter(e ->e.getEvaluacion() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getEvaluacion));
        System.out.println(est);
        System.out.println("Media de las evaluaciones: " + est.getAverage());
        System.out.println("Episodio Mejor evaluado: " + est.getMax());
        System.out.println("Episodio pero evaluado: " + est.getMin());
    }
}
