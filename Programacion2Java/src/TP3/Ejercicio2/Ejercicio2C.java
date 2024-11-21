package TP3.Ejercicio2;


import TDAs.api.ColaTDA;
import TDAs.impl.cola.ColaEstatica;
import TDAs.impl.conjunto.ConjuntoEstatico;

public class Ejercicio2C {
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

        ConjuntoEstatico repetidos = elementosRepetidos(cola);

        System.out.println("Elementos repetidos:");
        imprimirConjunto(repetidos);
    }

    private static ConjuntoEstatico elementosRepetidos(ColaTDA cola) {
        ConjuntoEstatico vistos = new ConjuntoEstatico();
        vistos.inicializarConjunto();
        ConjuntoEstatico repetidos = new ConjuntoEstatico();
        repetidos.inicializarConjunto();

        ColaTDA auxiliar = new ColaEstatica();
        auxiliar.inicializarCola();

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            cola.desacolar();

            if (vistos.pertenece(elemento)) {
                repetidos.agregar(elemento);
            } else {
                vistos.agregar(elemento);
            }

            auxiliar.acolar(elemento);
        }

        while (!auxiliar.colaVacia()) {
            cola.acolar(auxiliar.primero());
            auxiliar.desacolar();
        }

        return repetidos;
    }

    private static void imprimirConjunto(ConjuntoEstatico conjunto) {
        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            System.out.println(elemento);
            conjunto.sacar(elemento);
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
