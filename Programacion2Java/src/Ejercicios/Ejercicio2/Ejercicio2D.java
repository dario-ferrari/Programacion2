package Ejercicios.Ejercicio2;

import TDAs.api.PilaTDA;
import TDAs.impl.pila.PilaEstatica;
import TDAs.util.PopuladorPila;

/**
 * Ejercicio 2)D) Contar los elementos de una Pila:
 */
public class Ejercicio2D {
    public static void main(String[] args) {

        PilaTDA pila = new PilaEstatica();
        pila.inicializarPila();

        PopuladorPila populador = new PopuladorPila();
        pila = populador.llenarPila(pila);
        int elementos = populador.cantElementos();

        System.out.println("La cantidad de elementos de la Pila es: " + elementos);

    }
}
