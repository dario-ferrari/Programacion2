package TDAs.app;

import TDAs.impl.pila.PilaEstatica;
import TDAs.impl.pila.PilaEstatica2;
import TDAs.api.PilaTDA;

import java.util.Scanner;

public class PilaEstaticaMain {

    public static void main(String[] args) {
        //pila1();
        pila2();
    }

    public static void pila1() {
        PilaTDA pilaEstatica = new PilaEstatica();
        pilaEstatica.inicializarPila();
        pilaEstatica.apilar(1);
        pilaEstatica.apilar(2);
        pilaEstatica.apilar(3);

        System.out.print("Contenido de la Pila: ");

        while (pilaEstatica.pilaVacia()!=true){
            System.out.print(pilaEstatica.tope());
            pilaEstatica.desapilar();
        }
    }

    public static void pila2() {
        PilaTDA pilaEstatica2 = new PilaEstatica2();
        pilaEstatica2.inicializarPila();
        Scanner e = new Scanner(System.in);

        System.out.print("Contenido de la Pila (Caracter no-numérico para detener): ");
        try {
            while (e.hasNextInt()){
                pilaEstatica2.apilar(e.nextInt());
            }
        } catch (Exception error) {
            System.out.println("Pila llena.");
        }

        System.out.print("Contenido de la Pila: ");
        while (pilaEstatica2.pilaVacia()!=true){
            System.out.print(pilaEstatica2.tope());
            pilaEstatica2.desapilar();
        }

    }

}
