package TP3.Ejercicio3;

import TDAs.api.ConjuntoTDA;
import TDAs.impl.conjunto.ConjuntoEstatico;
import TDAs.util.PopuladorConjunto;

public class Ejercicio3B {
    public static void main(String[] args) {
        ConjuntoTDA A = new ConjuntoEstatico();
        ConjuntoTDA B = new ConjuntoEstatico();
        A.inicializarConjunto();
        B.inicializarConjunto();

        PopuladorConjunto populador = new PopuladorConjunto();
        A = populador.llenarConjunto(A);
        B = populador.llenarConjunto(B);

        ConjuntoTDA diferenciaSimetrica = calcularDiferenciaSimetricaConOperaciones(A, B);

        System.out.println("Diferencia Simétrica:");
        populador.imprimirConjunto(diferenciaSimetrica);
    }

    private static ConjuntoTDA calcularDiferenciaSimetricaConOperaciones(ConjuntoTDA A, ConjuntoTDA B) {
        ConjuntoTDA union = unionConjuntos(A, B);
        ConjuntoTDA interseccion = interseccionConjuntos(A, B);
        return diferenciaConjuntos(union, interseccion);
    }

    private static ConjuntoTDA unionConjuntos(ConjuntoTDA A, ConjuntoTDA B) {
        ConjuntoTDA resultado = clonarConjunto(A);
        ConjuntoTDA auxB = clonarConjunto(B);

        while (!auxB.conjuntoVacio()) {
            int elemento = auxB.elegir();
            auxB.sacar(elemento);
            if (!resultado.pertenece(elemento)) {
                resultado.agregar(elemento);
            }
        }

        return resultado;
    }

    private static ConjuntoTDA interseccionConjuntos(ConjuntoTDA A, ConjuntoTDA B) {
        ConjuntoTDA resultado = new ConjuntoEstatico();
        resultado.inicializarConjunto();
        ConjuntoTDA auxA = clonarConjunto(A);

        while (!auxA.conjuntoVacio()) {
            int elemento = auxA.elegir();
            auxA.sacar(elemento);
            if (B.pertenece(elemento)) {
                resultado.agregar(elemento);
            }
        }

        return resultado;
    }

    private static ConjuntoTDA diferenciaConjuntos(ConjuntoTDA A, ConjuntoTDA B) {
        ConjuntoTDA resultado = clonarConjunto(A);

        while (!B.conjuntoVacio()) {
            int elemento = B.elegir();
            B.sacar(elemento);
            if (resultado.pertenece(elemento)) {
                resultado.sacar(elemento);
            }
        }

        return resultado;
    }

    private static ConjuntoTDA clonarConjunto(ConjuntoTDA original) {
        ConjuntoTDA clon = new ConjuntoEstatico();
        clon.inicializarConjunto();
        while (!original.conjuntoVacio()) {
            int elemento = original.elegir();
            clon.agregar(elemento);
            original.sacar(elemento);
        }
        return clon;
    }
}
