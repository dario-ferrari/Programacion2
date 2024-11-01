package Ejercicios.Ejercicio2;

import TDAs.api.PilaTDA;
import TDAs.impl.pila.PilaEstatica2;
import TDAs.util.PopuladorPila;
import TDAs.impl.pila.PilaEstatica;

/**
 * Ejercicio 2)B) Copiar una pila en otra (dejándola en el mismo orden que la original):
 */
public class Ejercicio2B {

    public static void main(String[] args) {

        PilaTDA pila = new PilaEstatica2();
        pila.inicializarPila();

        PopuladorPila populador = new PopuladorPila();
        pila = populador.llenarPila(pila);
        int elementos = populador.cantElementos();
        PilaTDA copiaPila = copiarPila(pila, elementos);

        System.out.print("Contenido de la Pila Copiada: ");
        populador.imprimirPila(copiaPila);

    }

    private static PilaTDA copiarPila(PilaTDA pila, int e) {
        PilaTDA copia = new PilaEstatica();
        copia.inicializarPila();
        int contador = 0;
        int[] aux = new int[e];
        while (!pila.pilaVacia()){
            aux[contador] = pila.tope();
            contador++;
            pila.desapilar();
        }
        while (contador>0){
            copia.apilar(aux[contador-1]);
            contador--;
        }
        return copia;
    }

}
