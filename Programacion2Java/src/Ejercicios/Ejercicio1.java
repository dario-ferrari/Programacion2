package Ejercicios;

import TDAs.impl.pila.PilaEstatica2;
import TDAs.impl.pila.PilaEstatica;
import TDAs.interfaces.PilaTDA;
import TDAs.util.PopuladorPila;

public class Ejercicio1 {
    public static void main(String[] args) {

        PilaTDA pila = new PilaEstatica2();
        pila.inicializarPila();

        /**
         * Ejercicio 1)A) Pasar una pila a otra, dejándola en orden inverso:
         * Pila Estática.
         */
        PopuladorPila populador = new PopuladorPila();
        pila = populador.llenarPila(pila);
        PilaTDA nuevaPila = invertirPila(pila);

        System.out.print("Contenido de la Pila Invertida: ");
        while (nuevaPila.vacio()!=true){
            System.out.print(nuevaPila.tope());
            nuevaPila.desapilar();
        }

        /**
         * Ejercicio 1)B) Copiar una pila en otra (dejándola en el mismo orden que la original):
         */
        pila = populador.llenarPila(pila);
        PilaTDA copiaPila = copiarPila(pila);

        System.out.print("Contenido de la Pila Copiada: ");
        while (copiaPila.vacio()!=true){
            System.out.print(copiaPila.tope());
            copiaPila.desapilar();
        }

    }

    public static PilaTDA invertirPila(PilaTDA pila) {
        PilaTDA nueva = new PilaEstatica();
        nueva.inicializarPila();
        while(!pila.vacio()) {
            nueva.apilar(pila.tope());
            pila.desapilar();
        }
        return nueva;
    }

    private static PilaTDA copiarPila(PilaTDA pila) {
        PilaTDA copia = new PilaEstatica();
        int contador = 0;
        int[] aux;
        return copia;
    }

}
