package TP4.Ejercicio3;

import TDAs.api.ABBTDA;
import TDAs.impl.abb.ArbolABB;

public class Ejercicio3L {

    public static void main(String[] args) {

        ABBTDA arbol = new ArbolABB();
        arbol.inicializarABB();

        arbol.agregar(10);
        arbol.agregar(5);
        arbol.agregar(15);
        arbol.agregar(3);
        arbol.agregar(7);

        System.out.print("In-orden: ");
        inOrden(arbol);
        System.out.println();

        System.out.print("Pre-orden: ");
        preOrden(arbol);
        System.out.println();

        System.out.print("Post-orden: ");
        postOrden(arbol);
        System.out.println();
    }

    private static void inOrden(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            inOrden(arbol.hijoIzquierdo());
            System.out.print(arbol.raiz() + " ");
            inOrden(arbol.hijoDerecho());
        }
    }

    private static void preOrden(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            System.out.print(arbol.raiz() + " ");
            preOrden(arbol.hijoIzquierdo());
            preOrden(arbol.hijoDerecho());
        }
    }

    private static void postOrden(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            postOrden(arbol.hijoIzquierdo());
            postOrden(arbol.hijoDerecho());
            System.out.print(arbol.raiz() + " ");
        }
    }
}