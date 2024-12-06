package TP6;

import TDAs.api.ConjuntoTDA;
import TDAs.api.GrafoTDA;
import TDAs.impl.conjunto.ConjuntoDinamico;
import TDAs.impl.grafo.GrafoEstatico;

public class Ejercicio6 {
    public static void main(String[] args) {
        GrafoTDA grafo = new GrafoEstatico();
        grafo.inicializarGrafo();

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);

        grafo.agregarArista(1, 2, 5);
        grafo.agregarArista(3, 2, 7);

        ConjuntoTDA predecesores = predecesores(grafo, 2);
        System.out.println("Predecesores de 2:");
        imprimirConjunto(predecesores);
    }

    private static ConjuntoTDA predecesores(GrafoTDA grafo, int v) {
        ConjuntoTDA predecesores = new ConjuntoDinamico();
        predecesores.inicializarConjunto();
        ConjuntoTDA vertices = grafo.vertices();

        while (!vertices.conjuntoVacio()) {
            int origen = vertices.elegir();
            vertices.sacar(origen);
            if (grafo.existeArista(origen, v)) {
                predecesores.agregar(origen);
            }
        }
        return predecesores;
    }

    private static void imprimirConjunto(ConjuntoTDA conjunto) {
        while (!conjunto.conjuntoVacio()) {
            int valor = conjunto.elegir();
            System.out.print(valor + " ");
            conjunto.sacar(valor);
        }
        System.out.println();
    }
}