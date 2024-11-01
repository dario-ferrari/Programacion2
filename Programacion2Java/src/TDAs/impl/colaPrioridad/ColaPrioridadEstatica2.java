package TDAs.impl.colaPrioridad;

import TDAs.api.ColaPrioridadTDA;

import java.util.Scanner;

public class ColaPrioridadEstatica2 implements ColaPrioridadTDA {

    Scanner cantElement = new Scanner(System.in);
    private int[] prioridad;
    private int[] valor;
    private int cont;

    @Override
    public void inicializarCola() {
        System.out.println("Cantidad de elementos de la Cola con Prioridad Estática: ");
        int elementos = cantElement.nextInt();
        prioridad = new int[elementos];
        valor = new int[elementos];
    }

    @Override
    public void acolarPrioridad(int x, int p) {
        int i = cont-1;
        while(i>0 && p<=prioridad[i]) {
            prioridad[i+1] = prioridad[i];
            valor[i+1] = valor[i];
            i--;
        }
        prioridad[i+1] = p;
        valor[i+1] = x;
        cont++;
    }

    @Override
    public void desacolar() {
        cont--;
    }

    @Override
    public int primero() {
        return valor[cont-1];
    }

    @Override
    public boolean colaVacia() {
        return cont==0;
    }

    @Override
    public int prioridad() {
        return prioridad[cont-1];
    }
}
