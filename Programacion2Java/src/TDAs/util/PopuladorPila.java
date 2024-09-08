package TDAs.util;

import TDAs.api.PilaTDA;

import java.util.Scanner;

public class PopuladorPila {

    Scanner sc = new Scanner(System.in);
    private int cant;

    //La pila tiene que estar inicializada.
    public PilaTDA llenarPila(PilaTDA pila) {
        System.out.println("Ingrese contenido de la Pila - Caracter no numérico para completar: ");
        try {
            while (sc.hasNextLine()) {
                pila.apilar(sc.nextInt());
                cant++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return pila;

    }

    public int cantElementos() {
        return cant;
    }

}
