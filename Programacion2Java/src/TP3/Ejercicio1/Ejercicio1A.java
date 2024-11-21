package TP3.Ejercicio1;

import TDAs.api.PilaTDA;
import TDAs.impl.pila.PilaEstatica;
import TDAs.util.PopuladorPila;

public class Ejercicio1A {
    public static void main(String[] args) {
        PilaTDA pila = new PilaEstatica();
        pila.inicializarPila();

        PopuladorPila populador = new PopuladorPila();
        pila = populador.llenarPila(pila);

        System.out.println("¿Es capicúa?: " + esCapicua(pila));
    }

    private static boolean esCapicua(PilaTDA pila) {
        PilaTDA auxiliar = new PilaEstatica();
        auxiliar.inicializarPila();
        PilaTDA reversa = new PilaEstatica();
        reversa.inicializarPila();

        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            reversa.apilar(elemento);
            auxiliar.apilar(elemento);
            pila.desapilar();
        }

        boolean capicua = true;
        while (!auxiliar.pilaVacia()) {
            int original = auxiliar.tope();
            int inverso = reversa.tope();
            if (original != inverso) {
                capicua = false;
            }
            pila.apilar(original);
            auxiliar.desapilar();
            reversa.desapilar();
        }

        return capicua;
    }
}