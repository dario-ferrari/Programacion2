package Ejercicios.Ejercicio6;

import TDAs.api.ColaPrioridadTDA;
import TDAs.impl.colaPrioridad.ColaPrioridadEstatica2;
import TDAs.util.PopuladorColaPrioridad;

/**
 * 6)B) Determinar si dos Colas con prioridad son idénticas.
 */
public class Ejercicio6B {
    public static void main(String[] args) {
        ColaPrioridadTDA cola1 = new ColaPrioridadEstatica2();
        cola1.inicializarCola();
        PopuladorColaPrioridad populadorColaPrioridad = new PopuladorColaPrioridad();
        cola1 = populadorColaPrioridad.llenarColaPrioridad(cola1);

        ColaPrioridadTDA cola2 = new ColaPrioridadEstatica2();
        cola2.inicializarCola();
        cola2 = populadorColaPrioridad.llenarColaPrioridad(cola2);

        boolean comparadas = comparar(cola1, cola2);

        if(comparadas) {
            System.out.println("Son idénticas.");
        } else {
            System.out.println("No son idénticas.");
        }

    }

    public static boolean comparar(ColaPrioridadTDA c1, ColaPrioridadTDA c2) {
        while(!c1.colaVacia()) {
            if(c1.primero() != c2.primero() || c1.prioridad() != c2.prioridad()) {
                return false;
            } else {
                c1.desacolar();
                c2.desacolar();
            }
        }
        return true;
    }
}
