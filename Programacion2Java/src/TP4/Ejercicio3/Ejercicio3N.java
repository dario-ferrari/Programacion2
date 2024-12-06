package TP4.Ejercicio3;

import TDAs.api.ABBTDA;
import TDAs.impl.abb.ArbolABB;

public class Ejercicio3N {
    public static void main(String[] args) {
        ABBTDA arbol = new ArbolABB();
        arbol.inicializarABB();

        arbol.agregar(10);
        arbol.agregar(5);
        arbol.agregar(15);
        arbol.agregar(3);
        arbol.agregar(7);

        int v = 10;

        int resultado = anterior(arbol, v, -1);

        if (resultado == -1) {
            System.out.println("El elemento " + v + " no tiene predecesor en el ABB.");
        } else {
            System.out.println("El predecesor de " + v + " es: " + resultado);
        }
    }

    private static int anterior(ABBTDA arbol, int v, int previo) {
        if (arbol.arbolVacio()) {
            return previo;
        }

        if (arbol.raiz() < v) {
            previo = arbol.raiz();
            return anterior(arbol.hijoDerecho(), v, previo);
        } else {
            return anterior(arbol.hijoIzquierdo(), v, previo);
        }
    }
}