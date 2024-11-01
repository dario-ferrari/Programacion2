package TDAs.impl.colaPrioridad;

import TDAs.api.ColaPrioridadTDA;

public class ColaPrioridadEstatica implements ColaPrioridadTDA {

    private int[] prioridad;
    private int[] valor;
    private int cont;

    @Override
    public void inicializarCola() {
        prioridad = new int[100];
        valor = new int[100];
        cont = 0;
    }

    @Override
    public void acolarPrioridad(int x, int p) {
        int i = cont-1;
        while(i>=0 && p<=prioridad[i]) {
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
        return cont ==0;
    }

    @Override
    public int prioridad() {
        return prioridad[cont-1];
    }
}
