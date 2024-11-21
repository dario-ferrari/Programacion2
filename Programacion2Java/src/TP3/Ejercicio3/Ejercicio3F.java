package TP3.Ejercicio3;

import TDAs.api.ConjuntoTDA;
import TDAs.api.PilaTDA;
import TDAs.api.ColaTDA;
import TDAs.impl.pila.PilaEstatica;
import TDAs.impl.cola.ColaEstatica;
import TDAs.impl.conjunto.ConjuntoEstatico;
import TDAs.util.PopuladorPila;
import TDAs.util.PopuladorCola;

public class Ejercicio3F {
    public static void main(String[] args) {
        PilaTDA pila = new PilaEstatica();
        ColaTDA cola = new ColaEstatica();
        pila.inicializarPila();
        cola.inicializarCola();

        PopuladorPila populadorPila = new PopuladorPila();
        PopuladorCola populadorCola = new PopuladorCola();

        pila = populadorPila.llenarPila(pila);
        cola = populadorCola.llenarCola(cola);

        ConjuntoTDA conjuntoInterseccion = generarInterseccionPilaCola(pila, cola);
        System.out.println("Conjunto de elementos comunes entre Pila y Cola:");
        imprimirConjunto(conjuntoInterseccion);
    }

    private static ConjuntoTDA generarInterseccionPilaCola(PilaTDA pila, ColaTDA cola) {
        ConjuntoTDA conjunto = new ConjuntoEstatico();
        conjunto.inicializarConjunto();

        PilaTDA auxPila = new PilaEstatica();
        auxPila.inicializarPila();

        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            pila.desapilar();
            auxPila.apilar(elemento);
        }

        while (!auxPila.pilaVacia()) {
            int elemento = auxPila.tope();
            auxPila.desapilar();
            if (perteneceEnCola(cola, elemento)) {
                conjunto.agregar(elemento);
            }
        }

        return conjunto;
    }

    private static boolean perteneceEnCola(ColaTDA cola, int elemento) {
        boolean encontrado = false;
        ColaTDA auxCola = new ColaEstatica();
        auxCola.inicializarCola();

        while (!cola.colaVacia()) {
            int valor = cola.primero();
            cola.desacolar();
            auxCola.acolar(valor);

            if (valor == elemento) {
                encontrado = true;
            }
        }

        while (!auxCola.colaVacia()) {
            cola.acolar(auxCola.primero());
            auxCola.desacolar();
        }

        return encontrado;
    }

    private static void imprimirConjunto(ConjuntoTDA conjunto) {
        ConjuntoTDA aux = new ConjuntoEstatico();
        aux.inicializarConjunto();

        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            System.out.print(elemento + " ");
            aux.agregar(elemento);
            conjunto.sacar(elemento);
        }

        while (!aux.conjuntoVacio()) {
            conjunto.agregar(aux.elegir());
            aux.sacar(aux.elegir());
        }

        System.out.println();
    }
}
