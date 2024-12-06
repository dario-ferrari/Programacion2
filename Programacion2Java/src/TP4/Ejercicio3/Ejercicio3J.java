package TP4.Ejercicio3;

import TDAs.api.ABBTDA;
import TDAs.impl.abb.ArbolABB;

public class Ejercicio3J {
    public static void main(String[] args) {
        ABBTDA arbol1 = new ArbolABB();
        ABBTDA arbol2 = new ArbolABB();

        arbol1.inicializarABB();
        arbol2.inicializarABB();

        arbol1.agregar(10);
        arbol1.agregar(5);
        arbol1.agregar(15);

        arbol2.agregar(10);
        arbol2.agregar(5);
        arbol2.agregar(15);

        System.out.println("Los ABB son iguales: " + sonIguales(arbol1, arbol2));
    }

    private static boolean sonIguales(ABBTDA a, ABBTDA b) {
        if (a.arbolVacio() && b.arbolVacio()) return true;
        if (a.arbolVacio() || b.arbolVacio()) return false;

        return a.raiz() == b.raiz() &&
                sonIguales(a.hijoIzquierdo(), b.hijoIzquierdo()) &&
                sonIguales(a.hijoDerecho(), b.hijoDerecho());
    }
}