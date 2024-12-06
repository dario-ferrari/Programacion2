package TP4.Ejercicio3;

import TDAs.api.ABBTDA;
import TDAs.impl.abb.ArbolABB;

public class Ejercicio3H {
    public static void main(String[] args) {
        ABBTDA arbol = new ArbolABB();
        arbol.inicializarABB();

        arbol.agregar(10);
        arbol.agregar(5);
        arbol.agregar(15);
        arbol.agregar(3);
        arbol.agregar(7);
        arbol.agregar(13);
        arbol.agregar(17);

        int altura = calcularAltura(arbol);

        System.out.println("La altura del ABB es: " + altura);
    }

    private static int calcularAltura(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        }

        int alturaIzquierda = calcularAltura(arbol.hijoIzquierdo());
        int alturaDerecha = calcularAltura(arbol.hijoDerecho());

        return 1 + Math.max(alturaIzquierda, alturaDerecha);
    }
}