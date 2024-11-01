package TDAs.impl.cola;

import TDAs.api.ColaTDA;

public class ColaEstatica implements ColaTDA {

    private int[] cola;
    private int cont;

    @Override
    public void inicializarCola() {
        cola = new int[100];
        cont = 0;
    }

    @Override
    public void acolar(int elemento) {
        cola[cont] = elemento;
        cont++;
    }

    @Override
    public void desacolar() {
        int cont2 = cont;
        for (int i = 0; i < cont2-1; i++) {
            cola[i] = cola[i+1];
        }
        cont--;
    }

    @Override
    public int primero() {
        return cola[0];
    }

    @Override
    public boolean colaVacia() {
        return cont==0;
    }
}
