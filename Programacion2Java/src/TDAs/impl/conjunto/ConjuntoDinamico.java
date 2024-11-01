package TDAs.impl.conjunto;

import TDAs.api.ConjuntoTDA;

public class ConjuntoDinamico implements ConjuntoTDA{

    class Nodo{
        int dato;
        Nodo siguiente;
    }

    private Nodo primero;

    public void inicializarConjunto() {
        primero=null;
    }

    public void agregar(int x) {
        Nodo n=new Nodo();
        n.dato=x;
        n.siguiente=primero;
        primero=n;
    }

    public void sacar(int x) {
        if (primero.dato==x) {
            primero=primero.siguiente;
            return;
        }
        Nodo anterior=null;
        Nodo actual=primero;
        while (actual.dato!=x) {
            anterior=actual;
            actual=actual.siguiente;
        }
        anterior.siguiente=actual.siguiente;
    }

    public int elegir() {
        return primero.dato;
    }

    public boolean conjuntoVacio() {
        return primero==null;
    }

    public boolean pertenece(int x) {
        Nodo anterior=null;
        Nodo actual=primero;
        while(actual!=null) {
            anterior=actual;
            actual=actual.siguiente;
            if (anterior.dato==x) {
                return true;
            }
        }
        return false;
    }

}
