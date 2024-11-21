package TP3.Ejercicio3;

import TDAs.api.ConjuntoTDA;
import TDAs.api.PilaTDA;
import TDAs.api.ColaTDA;
import TDAs.impl.pila.PilaEstatica;
import TDAs.impl.cola.ColaEstatica;
import TDAs.impl.conjunto.ConjuntoEstatico;
import TDAs.util.PopuladorPila;
import TDAs.util.PopuladorCola;

public class Ejercicio3G {
    public static void main(String[] args) {
        PilaTDA pila = new PilaEstatica();
        ColaTDA cola = new ColaEstatica();
        pila.inicializarPila();
        cola.inicializarCola();

        PopuladorPila populadorPila = new PopuladorPila();
        PopuladorCola populadorCola = new PopuladorCola();

        pila = populadorPila.llenarPila(pila);
        cola = populadorCola.llenarCola(cola);

        boolean sonMismosElementos = verificarMismosElementos(pila, cola);
        System.out.println("Los elementos de la Pila y la Cola son los mismos: " + sonMismosElementos);
    }

    private static boolean verificarMismosElementos(PilaTDA pila, ColaTDA cola) {
        ConjuntoTDA conjuntoPila = new ConjuntoEstatico();
        ConjuntoTDA conjuntoCola = new ConjuntoEstatico();
        conjuntoPila.inicializarConjunto();
        conjuntoCola.inicializarConjunto();

        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            pila.desapilar();
            conjuntoPila.agregar(elemento);
        }

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            cola.desacolar();
            conjuntoCola.agregar(elemento);
        }

        return sonConjuntosIguales(conjuntoPila, conjuntoCola);
    }

    private static boolean sonConjuntosIguales(ConjuntoTDA A, ConjuntoTDA B) {
        if (cantidadElementos(A) != cantidadElementos(B)) {
            return false;
        }

        while (!A.conjuntoVacio()) {
            int elemento = A.elegir();
            if (!B.pertenece(elemento)) {
                return false;
            }
            A.sacar(elemento);
        }
        return true;
    }

    private static int cantidadElementos(ConjuntoTDA conjunto) {
        int contador = 0;
        ConjuntoTDA aux = new ConjuntoEstatico();
        aux.inicializarConjunto();

        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            aux.agregar(elemento);
            conjunto.sacar(elemento);
            contador++;
        }

        while (!aux.conjuntoVacio()) {
            conjunto.agregar(aux.elegir());
            aux.sacar(aux.elegir());
        }

        return contador;
    }
}
