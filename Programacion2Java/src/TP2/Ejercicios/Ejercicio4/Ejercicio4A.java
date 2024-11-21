package TP2.Ejercicios.Ejercicio4;

import TDAs.api.ConjuntoTDA;
import TDAs.impl.conjunto.ConjuntoEstatico;

/**
 * 4)A) Tamaño máximo acotado
 */
public class Ejercicio4A {

    public static void main(String[] args) {
        ConjuntoTDA conjunto = new ConjuntoEstatico();
        conjunto.inicializarConjunto();

        conjunto.agregar(5);
        conjunto.agregar(10);

        System.out.println("Pertenece 10: " + conjunto.pertenece(10));
        conjunto.sacar(10);
        System.out.println("Pertenece 10: " + conjunto.pertenece(10));
    }
}
