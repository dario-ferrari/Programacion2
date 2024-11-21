package TP3.Ejercicio3;

import TDAs.api.ConjuntoTDA;
import TDAs.impl.conjunto.ConjuntoEstatico;
import TDAs.util.PopuladorConjunto;

public class Ejercicio3E {
    public static void main(String[] args) {
        ConjuntoTDA conjunto = new ConjuntoEstatico();
        conjunto.inicializarConjunto();

        PopuladorConjunto populador = new PopuladorConjunto();
        conjunto = populador.llenarConjunto(conjunto);

        int cardinalidad = calcularCardinalidad(conjunto);
        System.out.println("La cardinalidad del conjunto es: " + cardinalidad);
    }

    private static int calcularCardinalidad(ConjuntoTDA conjunto) {
        int contador = 0;
        ConjuntoTDA aux = new ConjuntoEstatico();
        aux.inicializarConjunto();

        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            aux.agregar(elemento);
            conjunto.sacar(elemento);
            contador++;
        }

        while (!aux.conjuntoVacio()) {
            conjunto.agregar(aux.elegir());
            aux.sacar(aux.elegir());
        }

        return contador;
    }
}
