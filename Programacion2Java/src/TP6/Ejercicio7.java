package TP6;

import TDAs.api.ConjuntoTDA;
import TDAs.api.GrafoTDA;
import TDAs.impl.conjunto.ConjuntoDinamico;
import TDAs.impl.grafo.GrafoEstatico;

public class Ejercicio7 {
    public static void main(String[] args) {
        GrafoTDA grafo = new GrafoEstatico();
        grafo.inicializarGrafo();

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);

        grafo.agregarArista(1, 2, 5);

        ConjuntoTDA aislados = verticesAislados(grafo);
        System.out.println("Vértices aislados:");
        imprimirConjunto(aislados);
    }

    private static ConjuntoTDA verticesAislados(GrafoTDA grafo) {
        ConjuntoTDA aislados = new ConjuntoDinamico();
        aislados.inicializarConjunto();
        ConjuntoTDA vertices = grafo.vertices();

        while (!vertices.conjuntoVacio()) {
            int vertice = vertices.elegir();
            vertices.sacar(vertice);

            boolean aislado = true;
            ConjuntoTDA subVertices = grafo.vertices();
            while (!subVertices.conjuntoVacio()) {
                int otro = subVertices.elegir();
                subVertices.sacar(otro);

                if (grafo.existeArista(vertice, otro) || grafo.existeArista(otro, vertice)) {
                    aislado = false;
                    break;
                }
            }

            if (aislado) {
                aislados.agregar(vertice);
            }
        }
        return aislados;
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