package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;

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

        String[] arrayNombres = {"Marcos", "juan", "antonio"};
        // ¿Como convertir el array anterior a una lista de nombres?
        nombres = Arrays.asList(arrayNombres);
        // System.out.println(nombres);
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
        personas2.add(Persona.builder().nombre("Marcos").genero(Genero.HOMBRE).build());
        personas2.add(Persona.builder().nombre("Ruben").genero(Genero.HOMBRE).build());
        personas2.add(Persona.builder().nombre("Ellie").genero(Genero.MUJER).build());
        personas2.add(Persona.builder().nombre("Laira").genero(Genero.MUJER).build());

        elementosVarios = new ArrayList<>();
        elementosVarios.add(Persona.builder().nombre("Miguel").genero(Genero.HOMBRE).build());
        elementosVarios.add(Empleado.builder().nombre("Manuel").genero(Genero.HOMBRE)
                .departamento(Departamento.INFORMATICA).salario(1200.5).build());
        elementosVarios.add(Estudiante.builder().nombre("Ruben").genero(Genero.HOMBRE)
                .beca(2300).totalAsignaturas(10).build());
        elementosVarios.add(Estudiante.builder().nombre("Marcos").genero(Genero.HOMBRE)
                .beca(11500).totalAsignaturas(11).build());
        elementosVarios.add(Estudiante.builder().nombre("Juan").genero(Genero.HOMBRE)
                .beca(9500).totalAsignaturas(9).build());
        elementosVarios.add(Empleado.builder().nombre("Miriam").genero(Genero.MUJER)
                .departamento(Departamento.INFORMATICA).salario(1100.5).build());
        elementosVarios.add(Empleado.builder().nombre("Alba").genero(Genero.MUJER)
                .departamento(Departamento.INFORMATICA).salario(1470.21).build());
        elementosVarios.add(Empleado.builder().nombre("Laura").genero(Genero.MUJER)
                .departamento(Departamento.INFORMATICA).salario(1700.89).build());
        /*
         * Recorrer colecciones (Traversing Collections)
         * 
         * 1. Utilizando un iterador (Interfaz Iterator), es la unica forma
         * de eliminar un elemento de la coleccion mientras se recorre.
         * 
         * 2. Utilizando un for mejorado.
         * 
         * 3. La FORMA SUGERIDA (RECOMENDADA). Utilizando Operaciones de Agregado
         * (Metodos
         * de la clase Stream, las expresiones Lambda y los Metodos por referencia).
         */

 /*
         * Utilizando un iterador, vamos a recorrer la coleccion de personas2, para
         * eliminar
         * las personas del genero HOMBRE
         */
        Iterator<Persona> iterator = personas2.iterator();
        // System.out.println(personas2);
        while (iterator.hasNext()) {
            if (iterator.next().getGenero() == Genero.HOMBRE) {
                iterator.remove();
            }
        }
        // System.out.println(personas2);

        /*
         * Ejercicio # 1
         * 
         * Utilizando un Iterador
         * 
         * Recorrer la coleccion de personas2 y mostrar las personas del genero HOMBRE,
         * que ademas tengan
         * un nombre con una longitud igual o menor a 5 caracteres
         */
        List<Persona> personas3 = new ArrayList<>();
        personas3.add(Persona.builder().nombre("Marcos").genero(Genero.HOMBRE).build());
        personas3.add(Persona.builder().nombre("Ruben").genero(Genero.HOMBRE).build());
        personas3.add(Persona.builder().nombre("Ellie").genero(Genero.MUJER).build());
        personas3.add(Persona.builder().nombre("Laira").genero(Genero.MUJER).build());
        Iterator<Persona> i = personas3.iterator();
        while (i.hasNext()) {
            Persona persona = i.next();
            if (persona.getGenero().equals(Genero.HOMBRE) && persona.getNombre().length() <= 5) {
                System.out.println(persona.getNombre());
            }
        }

        //Utilizando el for mejorado, recorrer la lista elementosVarios y calcular el promedio de las becas
        // vsmos a emplear pattern matching
        double sumatoriaBecas = 0;
        int studentCounter = 0;
        double promedioBecas = 0;

        for (Object obj : elementosVarios) {
            // Como saber de que clase es el objeto que sacamos en cada iteracion
            // Utilizando el operador instanceof y tambien pattern matching
            if (obj instanceof Estudiante estudiante) {
                sumatoriaBecas += estudiante.getBeca();
                studentCounter++;
            }

        }

        promedioBecas = sumatoriaBecas / studentCounter;
        System.out.println("El promdio de becas es: " + promedioBecas);

        /* 
            Utilizando Operaciones de Agregado, que implica el uso de:

            1. Metodos de la clase Stream: 
            2. Concepto de Tuberia o pipeline, es un conjunto de metodos de agregados
            3. Interfaces Funcionales
            4. Clase Anonima
            5. Expresiones Lambda
            6. Metodos por referencia

            Recorrer la coleccion de elementosVarios para obtener el salario promedio de los empleados
            * del genero MUJER
         */
        // Hay que instanciar un objeto de la clase filtro
        // Filtro filtro = new Filtro();
        //el tipo opciones es una cajita donde puede venir el tipo o null, protegiendote del null pointer exception
        OptionalDouble optionalDouble =  elementosVarios.stream().filter(new Filtro()).mapToDouble(new Mapeador()).average();

        double salarioPromedio;

        if (optionalDouble.isPresent()) {
            salarioPromedio = optionalDouble.getAsDouble();
        }
    }
}
