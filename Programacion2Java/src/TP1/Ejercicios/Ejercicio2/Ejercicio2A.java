package TP1.Ejercicios.Ejercicio2;

import TDAs.impl.pila.PilaEstatica2;
import TDAs.impl.pila.PilaEstatica;
import TDAs.api.PilaTDA;
import TDAs.util.PopuladorPila;

/**
 * Ejercicio 2)A) Pasar una pila a otra, dejándola en orden inverso:
 * Pila Estática.
 */
public class Ejercicio2A {
    public static void main(String[] args) {

        PilaTDA pila = new PilaEstatica2();
        pila.inicializarPila();

        PopuladorPila populador = new PopuladorPila();
        pila = populador.llenarPila(pila);
        PilaTDA nuevaPila = invertirPila(pila);

        System.out.print("Contenido de la Pila Invertida: ");
        populador.imprimirPila(nuevaPila);

    }

    public static PilaTDA invertirPila(PilaTDA pila) {
        PilaTDA nueva = new PilaEstatica();
        nueva.inicializarPila();
        while(!pila.pilaVacia()) {
            nueva.apilar(pila.tope());
            pila.desapilar();
        }
        return nueva;
    }

}
