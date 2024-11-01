package Ejercicios.Ejercicio2;

import TDAs.api.PilaTDA;
import TDAs.impl.pila.PilaEstatica2;
import TDAs.util.PopuladorPila;

/**
 * Ejercicio 2)E) Sumar los elementos de una Pila:
 */
public class Ejercicio2E {
    public static void main(String[] args) {

        PilaTDA pila = new PilaEstatica2();
        pila.inicializarPila();

        PopuladorPila populador = new PopuladorPila();
        pila = populador.llenarPila(pila);

        int suma = sumarContenido(pila);
        System.out.print("La suma total de los elementos de la Pila es: " + suma);

    }

    private static int sumarContenido(PilaTDA pila) {
        int total = 0;
        while(!pila.pilaVacia()){
            total = total+pila.tope();
            pila.desapilar();
        }
        return total;
    }
}
