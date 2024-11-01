package Ejercicios.Ejercicio4;

import TDAs.api.ColaTDA;
import TDAs.impl.cola.ColaEstatica2;
import TDAs.util.PopuladorCola;

/**
 * Ejercicios 4)B) y 4)C)
 */
public class Ejercicio4B {
    public static void main(String[] args) {
        ColaTDA cola = new ColaEstatica2();
        cola.inicializarCola();

        PopuladorCola populadorCola = new PopuladorCola();
        cola = populadorCola.llenarCola(cola);

        cola = invertirCola(cola, populadorCola.cantElementos());
        System.out.println("Contenido de la Cola Invertida:");
        populadorCola.imprimirCola(cola);
    }

    private static ColaTDA invertirCola(ColaTDA cola, int cantElementos) {
        int[] aux = new int[cantElementos];
        int cont = cantElementos-1;
        while(!cola.colaVacia()) {
            aux[cont] = cola.primero();
            cont--;
            cola.desacolar();
        }
        for(int i = 0; i < cantElementos; i++) {
            cola.acolar(aux[i]);
        }
        return cola;
    }
}
