package TP6;

import TDAs.api.ConjuntoTDA;
import TDAs.api.GrafoTDA;
import TDAs.impl.grafo.GrafoEstatico;

public class Ejercicio9 {
    public static void main(String[] args) {
        GrafoTDA grafo = new GrafoEstatico();
        grafo.inicializarGrafo();

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);

        grafo.agregarArista(1, 2, 1);
        grafo.agregarArista(1, 3, 1);
        grafo.agregarArista(2, 1, 1);

        int grado = calcularGrado(grafo, 1);
        System.out.println("Grado del vértice 1: " + grado);
    }

    private static int calcularGrado(GrafoTDA grafo, int v) {
        int salientes = 0;
        int entrantes = 0;
        ConjuntoTDA vertices = grafo.vertices();

        ConjuntoTDA subVertices = grafo.vertices();
        while (!subVertices.conjuntoVacio()) {
            int destino = subVertices.elegir();
            subVertices.sacar(destino);
            if (grafo.existeArista(v, destino)) {
                salientes++;
            }
        }

        while (!vertices.conjuntoVacio()) {
            int origen = vertices.elegir();
            vertices.sacar(origen);
            if (grafo.existeArista(origen, v)) {
                entrantes++;
            }
        }

        return salientes - entrantes;
    }
}