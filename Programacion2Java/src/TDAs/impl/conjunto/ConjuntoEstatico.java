package TDAs.impl.conjunto;

import TDAs.api.ConjuntoTDA;

import java.util.Random;

public class ConjuntoEstatico implements ConjuntoTDA {

    private int[] vector;
    private int cant;
    private Random rand;
    private final int posInferior = 0;

    @Override
    public void inicializarConjunto() {
        vector = new int[100];
        cant = 0;
        rand = new Random(System.currentTimeMillis());
    }

    @Override
    public void agregar(int x) {
        vector[cant] = x;
        cant++;
    }

    @Override
    public int elegir() {
        int i = rand.nextInt(cant-1-posInferior+1)+posInferior;
        return vector[i];
    }

    @Override
    public void sacar(int x) {
        int i = cant-1;
        while(vector[i] != x) {
            i--;
        }
        vector[i] = vector[cant-1];
        cant--;
    }

    @Override
    public boolean pertenece(int x) {
        int b = cant;
        int c = 0;
        while( b != 0 ) {
            if(vector[c] == x) {
                return true;
            }
            b--;
            c--;
        }
        return false;
    }

    @Override
    public boolean conjuntoVacio() {
        return cant==0;
    }
}
