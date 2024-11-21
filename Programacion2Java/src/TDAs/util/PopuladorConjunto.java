package TDAs.util;

import TDAs.api.ConjuntoTDA;
import TDAs.impl.conjunto.ConjuntoEstatico;

import java.util.Scanner;

public class PopuladorConjunto {

    Scanner sc = new Scanner(System.in);
    private int cant;

    public ConjuntoTDA llenarConjunto(ConjuntoTDA conjunto) {
        System.out.println("Ingrese elementos del Conjunto - Caracter no numérico para completar: ");
        try {
            while (sc.hasNextInt()) {
                conjunto.agregar(sc.nextInt());
                cant++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return conjunto;
    }

    public int cantElementos() {
        return cant;
    }

    public void imprimirConjunto(ConjuntoTDA conjunto) {
        ConjuntoTDA aux = clonarConjunto(conjunto);
        while (!aux.conjuntoVacio()) {
            System.out.print(aux.elegir() + " - ");
            aux.sacar(aux.elegir());
        }
        System.out.println();
    }

    private ConjuntoTDA clonarConjunto(ConjuntoTDA original) {
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
