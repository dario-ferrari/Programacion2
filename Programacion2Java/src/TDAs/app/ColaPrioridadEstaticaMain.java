package TDAs.app;

import TDAs.api.ColaPrioridadTDA;
import TDAs.impl.colaPrioridad.ColaPrioridadEstatica;

public class ColaPrioridadEstaticaMain {

    public static void main(String[] args) {
        colaPrioridad();
    }

    private static void colaPrioridad() {
        ColaPrioridadTDA colaPrioridad = new ColaPrioridadEstatica();
        colaPrioridad.inicializarCola();
        colaPrioridad.acolarPrioridad(1, 1);
        colaPrioridad.acolarPrioridad(1, 2);
        colaPrioridad.acolarPrioridad(4, 5);
        colaPrioridad.acolarPrioridad(2, 6);
        colaPrioridad.acolarPrioridad(29, 4);

        System.out.println("Primero: " + colaPrioridad.primero());

        System.out.println("Prioridad: " + colaPrioridad.prioridad());

        System.out.println("Cola con Prioridad: ");
        while (!colaPrioridad.colaVacia()) {
            System.out.println(colaPrioridad.primero());
            colaPrioridad.desacolar();
        }
    }

}
