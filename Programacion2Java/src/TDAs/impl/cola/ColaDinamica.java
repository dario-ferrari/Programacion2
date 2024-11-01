package TDAs.impl.cola;

import TDAs.api.ColaTDA;

public class ColaDinamica implements ColaTDA {

    class Nodo {
        int dato;
        Nodo siguiente;
    }

    private Nodo inicio;
    private Nodo fin;

    public void inicializarCola() {
        inicio=null;
        fin=null;
    }

    public void acolar(int x) {
        Nodo n=new Nodo();
        n.dato=x;
        n.siguiente=null;
        if(inicio==null) {
            inicio=n;
            fin=n;
        } else {
            fin.siguiente=n;
            fin=n;
        }
    }

    public void desacolar() {
        inicio=inicio.siguiente;
        if(inicio==null) {
            fin=null;
        }
    }

    public int primero() {
        return inicio.dato;
    }

    public boolean colaVacia() {
        return inicio==null;
    }

}
