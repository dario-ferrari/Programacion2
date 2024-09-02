package TDAs.util;

import TDAs.interfaces.PilaTDA;

import java.util.Scanner;

public class PopuladorPila {

    Scanner sc = new Scanner(System.in);

    //La pila tiene que estar inicializada.
    public PilaTDA llenarPila(PilaTDA pila) {
        System.out.println("Ingrese contenido de la Pila - Caracter no numérico para completar: ");
        try {
            while (sc.hasNextLine()) {
                pila.apilar(sc.nextInt());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return pila;

    }

}
