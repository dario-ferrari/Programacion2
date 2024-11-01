package TDAs.impl.pila;

import TDAs.api.PilaTDA;

public class PilaDinamica implements PilaTDA {

    class Nodo {
        int dato;
        Nodo siguiente;
    }

    private Nodo inicio;
    private Nodo fin;

    public void inicializarPila() {
        inicio=null;
        fin=null;
    }

    public void apilar(int x) {
        Nodo n=new Nodo();
        n.dato=x;
        n.siguiente=null;
        if (inicio==null) {
            inicio=n;
            fin=n;
        } else {
            fin.siguiente=n;
            fin=n;
        }
    }

    public void desapilar() {
        if (inicio!=null) {
            Nodo actual=inicio;
            Nodo anterior=null;
            while (actual.siguiente!=null) {
                anterior=actual;
                actual=actual.siguiente;
            }
            if (inicio.siguiente==null) {
                fin=null;
                inicio=null;
            } else {
                fin=anterior;
                fin.siguiente=null;
            }
        }
    }

    public int tope() {
        return fin.dato;
    }

    public boolean pilaVacia() {
        return inicio==null;
    }
}
