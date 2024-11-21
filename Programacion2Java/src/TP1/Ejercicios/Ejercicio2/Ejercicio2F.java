package TP1.Ejercicios.Ejercicio2;

import TDAs.impl.pila.PilaEstatica2;
import TDAs.api.PilaTDA;
import TDAs.util.PopuladorPila;

/**
 * Ejercicio 2)F) Calcular el promedio de los elementos de una Pila:
 */
public class Ejercicio2F {
    public static void main(String[] args) {
        PilaTDA pila = new PilaEstatica2();
        pila.inicializarPila();

        PopuladorPila populador = new PopuladorPila();
        pila = populador.llenarPila(pila);
        int cantElementos = populador.cantElementos();

        float prom = calcularPromedio(pila, cantElementos);
        System.out.println("El promedio de los elementos de la Pila es: " + prom);
    }

    private static float calcularPromedio(PilaTDA pila, int cantElementos) {
        float promedio = 0;
        while (!pila.pilaVacia()){
            promedio = promedio+pila.tope();
            pila.desapilar();
        }
        return promedio/cantElementos;
    }
}
