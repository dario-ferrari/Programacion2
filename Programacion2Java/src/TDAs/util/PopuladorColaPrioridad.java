package TDAs.util;

import TDAs.api.ColaPrioridadTDA;

import java.util.Scanner;

public class PopuladorColaPrioridad {

    Scanner sc = new Scanner(System.in);
    private int cant;

    //La cola con prioridad tiene que estar inicializada.
    public ColaPrioridadTDA llenarColaPrioridad(ColaPrioridadTDA colaPrioridad) {
        if (cant!=0) {
            cant = 0;
        }
        System.out.println("Ingrese contenido de la Cola con Prioridad - Caracter no numérico para completar: ");
        System.out.println("Valor: ");
        try {
            while (sc.hasNextLine()) {
                if(cant!=0) {
                    System.out.println("Valor: ");
                };
                int valor = sc.nextInt();
                System.out.println("Prioridad: ");
                int prioridad = sc.nextInt();
                colaPrioridad.acolarPrioridad(valor, prioridad);
                cant++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return colaPrioridad;

    }

    public int cantElementos() {
        return cant;
    }

    public void imprimirColaPrioridad(ColaPrioridadTDA colaPrioridad) {
        while (!colaPrioridad.colaVacia()) {
            System.out.println("V: " + colaPrioridad.primero() + " - " + "P: " + colaPrioridad.prioridad());
            System.out.println();
            colaPrioridad.desacolar();
        }
    }

}
