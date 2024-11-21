package TP3.Ejercicio3;

import TDAs.api.ConjuntoTDA;
import TDAs.impl.conjunto.ConjuntoEstatico;

public class Ejercicio3C {
    public static boolean conjuntosIguales(ConjuntoTDA A, ConjuntoTDA B) {
        ConjuntoTDA auxA = clonarConjunto(A);
        ConjuntoTDA auxB = clonarConjunto(B);

        while (!auxA.conjuntoVacio()) {
            int elemento = auxA.elegir();
            auxA.sacar(elemento);
            if (!auxB.pertenece(elemento)) {
                return false;
            }
            auxB.sacar(elemento);
        }

        return auxB.conjuntoVacio();
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
