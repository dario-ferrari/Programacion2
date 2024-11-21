package TP3.Ejercicio3;

import TDAs.api.ConjuntoTDA;
import TDAs.impl.conjunto.ConjuntoEstatico;
import TDAs.util.PopuladorConjunto;

public class Ejercicio3D {
    public static void main(String[] args) {
        ConjuntoTDA A = new ConjuntoEstatico();
        ConjuntoTDA B = new ConjuntoEstatico();
        A.inicializarConjunto();
        B.inicializarConjunto();

        PopuladorConjunto populador = new PopuladorConjunto();
        A = populador.llenarConjunto(A);
        B = populador.llenarConjunto(B);

        boolean sonIguales = sonConjuntosIguales(A, B);
        System.out.println("Los conjuntos A y B son iguales: " + sonIguales);
    }

    private static boolean sonConjuntosIguales(ConjuntoTDA A, ConjuntoTDA B) {
        if (cantidadElementos(A) != cantidadElementos(B)) {
            return false;
        }

        ConjuntoTDA auxA = new ConjuntoEstatico();
        ConjuntoTDA auxB = new ConjuntoEstatico();
        auxA.inicializarConjunto();
        auxB.inicializarConjunto();

        while (!A.conjuntoVacio()) {
            int elemento = A.elegir();
            auxA.agregar(elemento);
            A.sacar(elemento);
        }

        while (!B.conjuntoVacio()) {
            int elemento = B.elegir();
            auxB.agregar(elemento);
            B.sacar(elemento);
        }

        while (!auxA.conjuntoVacio()) {
            int elemento = auxA.elegir();
            if (!auxB.pertenece(elemento)) {
                return false;
            }
            auxA.sacar(elemento);
        }

        return true;
    }

    private static int cantidadElementos(ConjuntoTDA conjunto) {
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
