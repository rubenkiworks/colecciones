package com.example;

import java.util.function.ToDoubleFunction;

public class Mapeador implements ToDoubleFunction<Object>{

    @Override
    public double applyAsDouble(Object obj) {
        // Estamos usando un type casting para que el objeto sea un empleado obligatoriamente
        return ((Empleado)obj).getSalario();
    }

}
