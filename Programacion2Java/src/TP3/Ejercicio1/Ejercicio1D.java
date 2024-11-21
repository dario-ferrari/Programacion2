package TP3.Ejercicio1;

import TDAs.api.PilaTDA;
import TDAs.impl.conjunto.ConjuntoExtendido;
import TDAs.impl.pila.PilaEstatica;
import TDAs.util.PopuladorPila;

public class Ejercicio1D {
    public static void main(String[] args) {
        PilaTDA pila = new PilaEstatica();
        pila.inicializarPila();

        PopuladorPila populador = new PopuladorPila();
        pila = populador.llenarPila(pila);

        ConjuntoExtendido repetidos = elementosRepetidos(pila);
        System.out.println("Elementos repetidos:");
        imprimirConjunto(repetidos);
    }

    private static void imprimirConjunto(ConjuntoExtendido repetidos) {
        while (!repetidos.conjuntoVacio()) {
            int elemento = repetidos.elegir();
            System.out.println(elemento);
            repetidos.sacar(elemento);
        }
    }

    private static ConjuntoExtendido elementosRepetidos(PilaTDA pila) {
        PilaTDA auxiliar = new PilaEstatica();
        auxiliar.inicializarPila();
        ConjuntoExtendido vistos = new ConjuntoExtendido();
        ConjuntoExtendido repetidos = new ConjuntoExtendido();
        vistos.inicializarConjunto();
        repetidos.inicializarConjunto();

        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            pila.desapilar();
            if (vistos.pertenece(elemento)) {
                repetidos.agregar(elemento);
            } else {
                vistos.agregar(elemento);
            }
            auxiliar.apilar(elemento);
        }

        while (!auxiliar.pilaVacia()) {
            pila.apilar(auxiliar.tope());
            auxiliar.desapilar();
        }

        return repetidos;
    }
}

