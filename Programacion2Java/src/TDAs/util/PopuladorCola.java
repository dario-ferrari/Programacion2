package TDAs.util;

import TDAs.api.ColaTDA;

import java.util.Scanner;

public class PopuladorCola {
    Scanner sc = new Scanner(System.in);
    private int cant;

    //La cola tiene que estar inicializada.
    public ColaTDA llenarCola(ColaTDA cola) {
        if (cant!=0) {
            cant=0;
        }
        System.out.println("Ingrese contenido de la Cola - Caracter no numérico para completar: ");
        try {
            while (sc.hasNextLine()) {
                cola.acolar(sc.nextInt());
                cant++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return cola;

    }

    public int cantElementos() {
        return cant;
    }

    public void imprimirCola(ColaTDA cola) {
        while (!cola.colaVacia()){
            System.out.print(cola.primero() + " - ");
            cola.desacolar();
        }
    }
}
