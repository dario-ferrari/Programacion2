package TDAs.app;

import TDAs.api.ConjuntoTDA;
import TDAs.impl.conjunto.ConjuntoEstatico;

public class ConjuntoEstaticoMain {
    public static void main(String[] args) {
        conjuntoImplementacion();
    }

    private static void conjuntoImplementacion() {
        ConjuntoTDA conjunto = new ConjuntoEstatico();
        conjunto.inicializarConjunto();
        conjunto.agregar(1);
        conjunto.agregar(2);
        conjunto.agregar(3);
        conjunto.sacar(2);
        int e = conjunto.elegir();
        conjunto.pertenece(1);

        System.out.println("Conjunto creado: ");
        while(!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            System.out.println(elemento);
            conjunto.sacar(elemento);
        }
    }
}
