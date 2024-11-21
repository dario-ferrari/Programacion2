package TP1.Ejercicios.Ejercicio4;

import TDAs.api.ColaTDA;
import TDAs.api.PilaTDA;
import TDAs.impl.cola.ColaEstatica2;
import TDAs.impl.pila.PilaEstatica;
import TDAs.util.PopuladorCola;

/**
 * 4)F) Determinar si la Cola C1 es la inversa de la Cola C2. Dos Colas serán
 * inversas, si tienen los mismos elementos pero en orden inverso.
 */
public class Ejercicio4F {
    public static void main(String[] args) {
        ColaTDA cola = new ColaEstatica2();
        cola.inicializarCola();
        PopuladorCola populador = new PopuladorCola();
        cola = populador.llenarCola(cola);

        ColaTDA cola2 = new ColaEstatica2();
        cola2.inicializarCola();
        cola2 = populador.llenarCola(cola2);

        boolean inversa = esInversa(cola, cola2);

        if (inversa) {
            System.out.println("Es inversa");
        } else {
            System.out.println("No es inversa");
        }
    }

    private static boolean esInversa(ColaTDA cola, ColaTDA cola2) {
        PilaTDA pilaAux = copiarColaEnPila(cola);
        try {
            while(!cola2.colaVacia()) {
                if (cola2.primero()!= pilaAux.tope()) {
                    return false;
                }
                pilaAux.desapilar();
                cola2.desacolar();
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    /**
     * ----- LEER: -------
     * Hacer este mismo método en una clase aparte para poder acceder al mismo sin la necesidad de copiarlo,
     * digo esto por el hecho de que este mismo método lo estoy usando en Ejercicio4E.
     * @param cola
     * @return
     */
    private static PilaTDA copiarColaEnPila(ColaTDA cola) {
        PilaTDA pila = new PilaEstatica();
        pila.inicializarPila();
        while (!cola.colaVacia()) {
            pila.apilar(cola.primero());
            cola.desacolar();
        }
        return pila;
    }
}
