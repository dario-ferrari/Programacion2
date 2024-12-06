package TP6;

import TDAs.api.ConjuntoTDA;
import TDAs.api.GrafoTDA;
import TDAs.impl.conjunto.ConjuntoDinamico;
import TDAs.impl.grafo.GrafoEstatico;

public class Ejercicio4 {
    public static void main(String[] args) {
        GrafoTDA grafo = new GrafoEstatico();
        grafo.inicializarGrafo();

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);

        grafo.agregarArista(1, 2, 1);
        grafo.agregarArista(2, 3, 1);
        grafo.agregarArista(3, 4, 1);

        ConjuntoTDA dobles = adyacentesDobles(grafo, 1);
        System.out.println("Adyacentes dobles de 1:");
        imprimirConjunto(dobles);
    }

    private static ConjuntoTDA adyacentesDobles(GrafoTDA grafo, int v) {
        ConjuntoTDA adyacentes = new ConjuntoDinamico();
        adyacentes.inicializarConjunto();
        ConjuntoTDA vertices = grafo.vertices();

        while (!vertices.conjuntoVacio()) {
            int x = vertices.elegir();
            vertices.sacar(x);
            if (grafo.existeArista(v, x)) {
                ConjuntoTDA subAdyacentes = grafo.vertices();
                while (!subAdyacentes.conjuntoVacio()) {
                    int w = subAdyacentes.elegir();
                    subAdyacentes.sacar(w);
                    if (grafo.existeArista(x, w)) {
                        adyacentes.agregar(w);
                    }
                }
            }
        }
        return adyacentes;
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