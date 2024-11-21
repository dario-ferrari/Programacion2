package TP3.Ejercicio1;

import TDAs.api.PilaTDA;
import TDAs.impl.conjunto.ConjuntoExtendido;
import TDAs.impl.pila.PilaEstatica;
import TDAs.util.PopuladorPila;


public class Ejercicio1B {
    public static void main(String[] args) {
        PilaTDA pila = new PilaEstatica();
        pila.inicializarPila();

        PopuladorPila populador = new PopuladorPila();
        pila = populador.llenarPila(pila);

        eliminarRepetidos(pila);
        System.out.println("Pila sin elementos repetidos:");
        populador.imprimirPila(pila);
    }

    private static void eliminarRepetidos(PilaTDA pila) {
        PilaTDA auxiliar = new PilaEstatica();
        auxiliar.inicializarPila();
        ConjuntoExtendido vistos = new ConjuntoExtendido();
        vistos.inicializarConjunto();

        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            pila.desapilar();
            if (!vistos.pertenece(elemento)) {
                vistos.agregar(elemento);
                auxiliar.apilar(elemento);
            }
        }

        while (!auxiliar.pilaVacia()) {
            pila.apilar(auxiliar.tope());
            auxiliar.desapilar();
        }
    }
}
