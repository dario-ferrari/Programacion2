package TP1.Ejercicios.Ejercicio6;

import TDAs.api.ColaPrioridadTDA;
import TDAs.impl.colaPrioridad.ColaPrioridadEstatica;
import TDAs.impl.colaPrioridad.ColaPrioridadEstatica2;
import TDAs.util.PopuladorColaPrioridad;

/**
 * 6)A) Combinar dos colas con prioridades CP1 y CP2, generando una nueva
 * cola con prioridades. Considerar que a igual prioridad, los elementos de la CP1
 * son más prioritarios que los de la CP2.
 */
public class Ejercicio6A {
    public static void main(String[] args) {
        ColaPrioridadTDA c1 = new ColaPrioridadEstatica2();
        c1.inicializarCola();
        PopuladorColaPrioridad populadorColaPrioridad = new PopuladorColaPrioridad();
        c1 = populadorColaPrioridad.llenarColaPrioridad(c1);

        ColaPrioridadTDA c2 = new ColaPrioridadEstatica2();
        c2.inicializarCola();
        c2 = populadorColaPrioridad.llenarColaPrioridad(c2);

        ColaPrioridadTDA combinada = combinar(c1, c2);

        System.out.println("Cola con Prioridad Combinada: ");
        populadorColaPrioridad.imprimirColaPrioridad(combinada);
    }

    private static ColaPrioridadTDA combinar(ColaPrioridadTDA c1, ColaPrioridadTDA c2) {
        ColaPrioridadTDA combinada = new ColaPrioridadEstatica();
        combinada.inicializarCola();
        while(!c2.colaVacia()) {
            combinada.acolarPrioridad(c2.primero(), c2.prioridad());
            c2.desacolar();
        }
        while (!c1.colaVacia()) {
            combinada.acolarPrioridad(c1.primero(), c1.prioridad());
            c1.desacolar();
        }
        return combinada;
    }
}
