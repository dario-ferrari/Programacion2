package TP4.Ejercicio3;

import TDAs.api.ABBTDA;
import TDAs.impl.abb.ArbolABB;

public class Ejercicio3K {
    public static void main(String[] args) {
        ABBTDA arbol = new ArbolABB();
        arbol.inicializarABB();

        arbol.agregar(10);
        arbol.agregar(5);
        arbol.agregar(15);
        arbol.agregar(3);
        arbol.agregar(7);

        int nivel = 2;
        System.out.println("Cantidad de elementos en nivel " + nivel + ": " + contarEnNivel(arbol, nivel, 0));
    }

    private static int contarEnNivel(ABBTDA arbol, int nivel, int actual) {
        if (arbol.arbolVacio()) return 0;
        if (actual == nivel) return 1;

        return contarEnNivel(arbol.hijoIzquierdo(), nivel, actual + 1) +
                contarEnNivel(arbol.hijoDerecho(), nivel, actual + 1);
    }
}