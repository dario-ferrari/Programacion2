package TP6;

import TDAs.api.ConjuntoTDA;
import TDAs.api.GrafoTDA;
import TDAs.impl.conjunto.ConjuntoDinamico;
import TDAs.impl.grafo.GrafoEstatico;

public class Ejercicio8 {
    public static void main(String[] args) {
        GrafoTDA grafo = new GrafoEstatico();
        grafo.inicializarGrafo();

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);

        grafo.agregarArista(1, 3, 1);
        grafo.agregarArista(3, 2, 1);
        grafo.agregarArista(3, 4, 1);

        ConjuntoTDA puentes = verticesPuente(grafo, 1, 2);
        System.out.println("Vértices puente entre 1 y 2:");
        imprimirConjunto(puentes);
    }

    private static ConjuntoTDA verticesPuente(GrafoTDA grafo, int v1, int v2) {
        ConjuntoTDA puentes = new ConjuntoDinamico();
        puentes.inicializarConjunto();
        ConjuntoTDA vertices = grafo.vertices();

        while (!vertices.conjuntoVacio()) {
            int p = vertices.elegir();
            vertices.sacar(p);

            if (grafo.existeArista(v1, p) && grafo.existeArista(p, v2)) {
                puentes.agregar(p);
            }
        }

        return puentes;
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