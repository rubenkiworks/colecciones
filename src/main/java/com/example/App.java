package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        /*
         * ¿Que es una coleccion?
         * Es un contenedor, que permite agrupar elementos
         * de distintos tipos como si fuese una unica unidad.
         * 
         * ¿Para que se utilizan las colecciones?
         * Para almacenar, recuperar, manipular y comunicar datos agrupados.
         * 
         * El Framework de Collecciones. Es un conjunto de Interfaces, con metodos
         * que permiten tratar a todas las colecciones de la misma forma.
         * 
         * 
         */

        // La Interface List es una de las colecciones mas utilizadas,
        // permite almacenar elementos duplicados, al igual que todas las demas
        // interfaces es Generica.

        // ¿Que es la Genericidad? Es lo que permite implementar clases e interfaces
        // que trabajen con tipos de datos diferentes, pero en cada momento solo
        // pueden trabar con un solo tipo de dato, o datos relacionados.
        // Por lo general un desarrolllador no implementa metodos ni elementos (clases,
        // records, etc), sino que debe saber utilizarlos. Solamente los desarrolladores
        // que se dediquen a implementar bibliotecas (librerias) son los que tendran que
        // dominar la Genericidad a otro nivel.
        // ¿Que ventajas nos ofrece la genericidad? Que los errores se detectan
        // muy facilmente en tiempo de compilacion, en lugar de ejecucion donde
        // seria mucho mas dificil de detectar.

        // Declaracion de colecciones

        List<String> nombres;

        // List<String> nombres2;

        List<Persona> personas;

        List<?> elementosDeCualquierTipo;

        List<? super Persona> cualqPersonas;

        // Por tanto, si queremos tener una coleccion que admita Persona y todos
        // los subtipos de persona
        List<? super Persona> elementosVarios;

        // Importante
        // No permite almacenar elementos porque crea una lista inmutable,
        // ¿Y, para que sirve entonces? Para pasarla como parametro a determinados
        // metodos.
        List<? extends Persona> elementVar2;

        String[] arrayNombres = { "Marcos", "juan", "antonio" };
        // ¿Como convertir el array anterior a una lista de nombres?
        nombres = Arrays.asList(arrayNombres);
        System.out.println(nombres);
        // ¿Que desventajas tiene crear una lista a partir de un array?
        // Que la lista resultante es de tamaño fijo, es decir, que no
        // le puedes agregar elementos con el metodo add(), posteriormente.

        List<String> nombres2 = List.of("Ruben", "gjfghf");

        List<String> nombres3 = new ArrayList<>();

        nombres3.add("HJJHJHJ");
        nombres3.add("HJJHJHJ");

        Persona[] personaArray = {
                Persona.builder().nombre("hghgh").genero(Genero.HOMBRE).build(),
                Persona.builder().nombre("jkjgh").genero(Genero.OTRO).build()
        };

        personas = Arrays.asList(personaArray);

        List<Persona> personas2 = new ArrayList<>();
        personas2.add(Persona.builder().nombre("hghgh").genero(Genero.HOMBRE).build());
        personas2.add(Persona.builder().nombre("jkjgh").genero(Genero.HOMBRE).build());

        elementosVarios = new ArrayList<>();
        elementosVarios.add(Persona.builder().nombre("hghgh").genero(Genero.HOMBRE).build());
        elementosVarios.add(Empleado.builder().nombre("hghgh").genero(Genero.HOMBRE)
                .departamento(Departamento.INFORMATICA).salario(1200.5).build());
        elementosVarios.add(Estudiante.builder().nombre("hghgh").genero(Genero.HOMBRE)
                .beca(2300).totalAsignaturas(11).build());

    }
}
