package TP3.Ejercicio2;


import TDAs.api.ColaTDA;
import TDAs.impl.cola.ColaEstatica;

public class Ejercicio2B {
    public static void main(String[] args) {
        ColaTDA cola = new ColaEstatica();
        cola.inicializarCola();

        cola.acolar(1);
        cola.acolar(2);
        cola.acolar(3);
        cola.acolar(4);

        System.out.println("Cola original:");
        imprimirCola(cola);

        ColaTDA mitad1 = new ColaEstatica();
        ColaTDA mitad2 = new ColaEstatica();
        mitad1.inicializarCola();
        mitad2.inicializarCola();

        repartirCola(cola, mitad1, mitad2);

        System.out.println("Primera mitad:");
        imprimirCola(mitad1);
        System.out.println("Segunda mitad:");
        imprimirCola(mitad2);
    }

    private static void repartirCola(ColaTDA cola, ColaTDA mitad1, ColaTDA mitad2) {
        int size = 0;
        ColaTDA auxiliar = new ColaEstatica();
        auxiliar.inicializarCola();

        while (!cola.colaVacia()) {
            size++;
            auxiliar.acolar(cola.primero());
            cola.desacolar();
        }

        int mitad = size / 2;
        while (!auxiliar.colaVacia()) {
            if (mitad > 0) {
                mitad1.acolar(auxiliar.primero());
                mitad--;
            } else {
                mitad2.acolar(auxiliar.primero());
            }
            auxiliar.desacolar();
        }
    }

    private static void imprimirCola(ColaTDA cola) {
        ColaTDA auxiliar = new ColaEstatica();
        auxiliar.inicializarCola();

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            System.out.println(elemento);
            auxiliar.acolar(elemento);
            cola.desacolar();
        }

        while (!auxiliar.colaVacia()) {
            cola.acolar(auxiliar.primero());
            auxiliar.desacolar();
        }
    }
}

