package TDAs.impl.cola;

import TDAs.api.ColaTDA;

import java.util.Scanner;

public class ColaEstatica2 implements ColaTDA {

    Scanner cantElement = new Scanner(System.in);
    private int[] cola;
    private int cont;

    public void inicializarCola() {
        System.out.println("Cantidad de elementos de la Cola Estática: ");
        cola = new int[cantElement.nextInt()];
    }

    public void acolar(int elemento) {
        cola[cont] = elemento;
        /**if (cant!=0) {
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

        return cola;**/
        cont++;
    }

    public void desacolar() {
        int cont2 = cont;
        for (int i = 0; i < cont2-1; i++) {
            cola[i] = cola[i+1];
        }
        cont--;
    }

    public int primero() {
        return cola[0];
    }

    public boolean colaVacia() {
        return cont==0;
    }

}
