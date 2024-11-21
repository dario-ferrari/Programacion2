package TP3.Ejercicio2;

import TDAs.api.ColaTDA;
import TDAs.impl.cola.ColaEstatica;
import TDAs.impl.conjunto.ConjuntoEstatico;

public class Ejercicio2A {
    public static void main(String[] args) {
        ColaTDA cola = new ColaEstatica();
        cola.inicializarCola();

        cola.acolar(1);
        cola.acolar(2);
        cola.acolar(1);
        cola.acolar(3);
        cola.acolar(2);

        System.out.println("Cola original:");
        imprimirCola(cola);

        eliminarRepetidos(cola);

        System.out.println("Cola sin repeticiones:");
        imprimirCola(cola);
    }

    private static void eliminarRepetidos(ColaTDA cola) {
        ConjuntoEstatico conjunto = new ConjuntoEstatico();
        conjunto.inicializarConjunto();
        ColaTDA auxiliar = new ColaEstatica();
        auxiliar.inicializarCola();

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            cola.desacolar();
            if (!conjunto.pertenece(elemento)) {
                conjunto.agregar(elemento);
                auxiliar.acolar(elemento);
            }
        }

        while (!auxiliar.colaVacia()) {
            cola.acolar(auxiliar.primero());
            auxiliar.desacolar();
        }
    }

    private static void imprimirCola(ColaTDA cola) {
        ColaTDA auxiliar = new ColaEstatica();
        auxiliar.inicializarCola();

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            System.out.println(elemento);
            auxiliar.acolar(elemento);
            cola.desacolar();
        }

        while (!auxiliar.colaVacia()) {
            cola.acolar(auxiliar.primero());
            auxiliar.desacolar();
        }
    }
}

