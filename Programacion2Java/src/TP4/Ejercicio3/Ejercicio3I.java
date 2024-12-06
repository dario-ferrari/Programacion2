package TP4.Ejercicio3;

import TDAs.api.ABBTDA;
import TDAs.impl.abb.ArbolABB;

public class Ejercicio3I {
    public static void main(String[] args) {
        ABBTDA arbol1 = new ArbolABB();
        ABBTDA arbol2 = new ArbolABB();

        arbol1.inicializarABB();
        arbol2.inicializarABB();

        arbol1.agregar(10);
        arbol1.agregar(5);
        arbol1.agregar(15);

        arbol2.agregar(20);
        arbol2.agregar(10);
        arbol2.agregar(25);

        System.out.println("Los ABB tienen la misma forma: " + mismaForma(arbol1, arbol2));
    }

    private static boolean mismaForma(ABBTDA a, ABBTDA b) {
        if (a.arbolVacio() && b.arbolVacio()) return true;
        if (a.arbolVacio() || b.arbolVacio()) return false;

        return mismaForma(a.hijoIzquierdo(), b.hijoIzquierdo()) &&
                mismaForma(a.hijoDerecho(), b.hijoDerecho());
    }
}
