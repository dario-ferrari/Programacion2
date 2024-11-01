package Ejercicios.Ejercicio2;

import TDAs.api.PilaTDA;
import TDAs.impl.pila.PilaEstatica2;
import TDAs.util.PopuladorPila;

/**
 * Ejercicio 2)C) Invertir el contenido de una Pila:
 */
public class Ejercicio2C {
    public static void main(String[] args) {

        PilaTDA pila = new PilaEstatica2();
        pila.inicializarPila();

        PopuladorPila populador = new PopuladorPila();
        pila = populador.llenarPila(pila);
        int elementos = populador.cantElementos();

        invertirContenido(pila, elementos);
        System.out.print("Contenido de la Pila Invertida: ");
        populador.imprimirPila(pila);

    }

    private static PilaTDA invertirContenido(PilaTDA pila, int elementos) {
        int cont = 0;
        int[] aux = new int[elementos];
        while(!pila.pilaVacia()){
            aux[cont] = pila.tope();
            cont++;
            pila.desapilar();
        }
        for (int i = 0; i < elementos-1; i++) {
            pila.apilar(aux[i]);
        }
        return pila;
    }
}
