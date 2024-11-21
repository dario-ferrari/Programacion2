package TP3.Ejercicio1;

import TDAs.api.PilaTDA;
import TDAs.impl.pila.PilaEstatica;
import TDAs.util.PopuladorPila;

public class Ejercicio1C {
    public static void main(String[] args) {
        PilaTDA pila = new PilaEstatica();
        pila.inicializarPila();

        PopuladorPila populador = new PopuladorPila();
        pila = populador.llenarPila(pila);

        PilaTDA mitad1 = new PilaEstatica();
        PilaTDA mitad2 = new PilaEstatica();
        mitad1.inicializarPila();
        mitad2.inicializarPila();

        repartirMitades(pila, mitad1, mitad2);
        System.out.println("Primera mitad:");
        populador.imprimirPila(mitad1);
        System.out.println("Segunda mitad:");
        populador.imprimirPila(mitad2);
    }

    private static void repartirMitades(PilaTDA pila, PilaTDA mitad1, PilaTDA mitad2) {
        PilaTDA auxiliar = new PilaEstatica();
        auxiliar.inicializarPila();

        int tamano = 0;
        while (!pila.pilaVacia()) {
            auxiliar.apilar(pila.tope());
            pila.desapilar();
            tamano++;
        }

        int mitad = tamano / 2;
        while (!auxiliar.pilaVacia()) {
            if (tamano > mitad) {
                mitad1.apilar(auxiliar.tope());
            } else {
                mitad2.apilar(auxiliar.tope());
            }
            pila.apilar(auxiliar.tope());
            auxiliar.desapilar();
            tamano--;
        }
    }
}

