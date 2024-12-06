package TP4.Ejercicio3;

import TDAs.api.ABBTDA;
import TDAs.impl.abb.ArbolABB;

public class Ejercicio3M {
    public static void main(String[] args) {
        ABBTDA arbol = new ArbolABB();
        arbol.inicializarABB();

        arbol.agregar(10);
        arbol.agregar(5);
        arbol.agregar(15);
        arbol.agregar(3);
        arbol.agregar(7);

        int k = 7;
        System.out.print("Elementos mayores que " + k + ": ");
        mayoresQue(arbol, k);
        System.out.println();
    }

    private static void mayoresQue(ABBTDA arbol, int k) {
        if (!arbol.arbolVacio()) {
            if (arbol.raiz() > k) System.out.print(arbol.raiz() + " ");
            mayoresQue(arbol.hijoIzquierdo(), k);
            mayoresQue(arbol.hijoDerecho(), k);
        }
    }
}