# Screenmatch \- Ejercicio del curso Lambdas, Streams y Srping  - Alura Oracle

Descripción
1. Proyecto realizado para seguir un curso sobre Java, lambdas y streams.  
   Implementa un cliente sencillo que consume la API de OMDb, procesa datos de series y episodios y muestra estadísticas y filtros usando Streams.

Tecnologías
1. Java (versión compatible: 11+ / 17+ recomendada)  
2. Spring Boot (para estructura del proyecto)  
3. Maven (gestión de dependencias y compilación)  
4. Jackson (mapeo JSON \-> objetos)

Estructura destacada
1. `src/main/java` \- código fuente principal (modelos, servicios, clase principal)  
2. `src/test/java` \- pruebas unitarias (si existen)  
3. `pom.xml` \- dependencias y configuración de Maven

Requisitos
1. JDK 11 o superior instalado  
2. Maven instalado  
3. Conexión a Internet para consumir la API OMDb

Cómo ejecutar
1. Construir el proyecto:
   ```bash
   mvn clean package -DskipTests

Ejecutar con Spring Boot:
mvn spring-boot:run

O ejecutar el JAR generado:
java -jar target/<nombre-del-jar>.jar

Comandos útiles
Ejecutar tests:
mvn test

Limpiar y recompilar:
mvn clean install

Notas
El proyecto fue desarrollado como ejercicio para practicar consumo de APIs, mapeo con Jackson, uso de records y manejo de Streams en Java.
Si hay discrepancias con el repositorio del instructor (métodos generados por record, nombres de componentes, o clases compiladas en caché), ejecutar una limpieza completa (mvn clean) y asegurarse de estar en la misma rama/commit que el material del curso.
Autor
Ariel Plaza
