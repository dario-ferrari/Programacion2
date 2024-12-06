package TP6;

import TDAs.api.ConjuntoTDA;
import TDAs.api.GrafoTDA;
import TDAs.impl.grafo.GrafoEstatico;

public class Ejercicio5 {
    public static void main(String[] args) {
        GrafoTDA grafo = new GrafoEstatico();
        grafo.inicializarGrafo();

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);

        grafo.agregarArista(1, 2, 5);
        grafo.agregarArista(1, 3, 10);

        int mayor = mayorCostoSalientes(grafo, 1);
        System.out.println("Mayor costo de las aristas salientes: " + mayor);
    }

    private static int mayorCostoSalientes(GrafoTDA grafo, int v) {
        int mayor = 0;
        ConjuntoTDA vertices = grafo.vertices();

        while (!vertices.conjuntoVacio()) {
            int destino = vertices.elegir();
            vertices.sacar(destino);
            if (grafo.existeArista(v, destino)) {
                int peso = grafo.pesoArista(v, destino);
                if (peso > mayor) {
                    mayor = peso;
                }
            }
        }
        return mayor;
    }
}