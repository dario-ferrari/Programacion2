package Ejercicios.Ejercicio4;

import TDAs.api.ColaTDA;
import TDAs.api.PilaTDA;
import TDAs.impl.cola.ColaEstatica2;
import TDAs.impl.pila.PilaEstatica;
import TDAs.impl.pila.PilaEstatica2;
import TDAs.util.PopuladorCola;

/**
 * 4)E) Determinar si una Cola es capicúa o no. Para ser capicúa debe cumplir
 * que el primer elemento es igual al último, el segundo igual al penúltimo, etc.
 */
public class Ejercicio4E {
    public static void main(String[] args) {

        ColaTDA cola = new ColaEstatica2();
        cola.inicializarCola();
        PopuladorCola populador = new PopuladorCola();
        cola = populador.llenarCola(cola);
        int cantElementosCola = populador.cantElementos();

        boolean capicua = capicua(cola, cantElementosCola);

        if(capicua) {
            System.out.println("Es capicúa.");
        } else {
            System.out.println("No es capicúa.");
        }

    }

    /**
     * Teniendo en cuenta que la pila que voy a crear va a tener los mismos elementos que la cola (pero invertidos
     * por la naturaleza propia de la pila), solo comparo las mitades de cada TDA para reducir la complejidad temporal
     * y no comparar el 100% de los elementos.
     * @param cola
     * @param elementos
     * @return
     */
    private static boolean capicua(ColaTDA cola, int elementos) {
        ColaTDA copia = cola;
        PilaTDA pila = copiarColaEnPila(copia, elementos);
        int mitad = elementos / 2;
        while (elementos!=mitad) {
            if (cola.primero()!= pila.tope()) {
                return false;
            }
            elementos--;
        }
        return true;
    }

    private static PilaTDA copiarColaEnPila(ColaTDA cola, int elementos) {
        PilaTDA pila = new PilaEstatica2();
        pila.inicializarPila();
        while (!cola.colaVacia()) {
            pila.apilar(cola.primero());
            cola.desacolar();
        }
        return pila;
    }
}
