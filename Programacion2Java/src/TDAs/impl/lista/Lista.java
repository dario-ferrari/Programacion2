package TDAs.impl.lista;

import TDAs.api.ColaTDA;
import TDAs.api.ListaTDA;
import TDAs.impl.cola.ColaEstatica;

public class Lista implements ListaTDA {

    class Nodo {
        int dato;
        Nodo siguiente;
    };

    private Nodo inicio;


    public void inicializarLista() {
        inicio=null;
    }

    public void agregarInicio(int x) {
        //Creo un Nodo "n". Le asigno el valor "x" ingresado como parámetro en la variable "dato". El nodo "siguiente"
        //dentro de "n" lo hago igual al nodo "inicio" (que es null). Y el nodo "inicio" lo hago igual a "n".
        Nodo n=new Nodo();
        n.dato=x;
        n.siguiente=inicio;
        inicio=n;
    }

    public void agregarFinal(int x) {
        if (inicio==null) {
            agregarInicio(x);
        }
        else {
            Nodo n=new Nodo();
            n.dato=x;
            n.siguiente=null;
            Nodo actual=inicio;
            while(actual.siguiente!=null) {
                actual=actual.siguiente;
            }
            actual.siguiente=n;
        }
    }

    public void eliminarInicio() {
        if (inicio!=null) {
            inicio=inicio.siguiente;
        }
    }

    public void eliminarFinal() {
        if (inicio!=null) {
            if (inicio.siguiente==null) {
                eliminarInicio();
            }
            else {
                Nodo actual=inicio;
                Nodo anterior=null;
                while (actual.siguiente!=null) {
                    anterior=actual;
                    actual=actual.siguiente;
                }
                anterior.siguiente=actual.siguiente;
            }
        }
    }

    public void eliminar(int x) {
        if (inicio!=null) {
            if(inicio.dato==x) {
                eliminarInicio();
            }
            else {
                Nodo actual=inicio;
                Nodo anterior=null;
                while(actual!=null && actual.dato!=x) {
                    anterior=actual;
                    actual=actual.siguiente;
                }
                if (actual!=null) {
                    anterior.siguiente=actual.siguiente;
                }
            }
        }
    }

    public boolean existe(int x) {
        Nodo actual=inicio;
        while(actual!=null && actual.dato!=x) {
            actual=actual.siguiente;
        }
        return actual!=null;
    }

    public ColaTDA valores() {
        ColaTDA r=new ColaEstatica();
        r.inicializarCola();
        Nodo actual=inicio;
        while (actual!=null) {
            r.acolar(actual.dato);
            actual=actual.siguiente;
        }
        return r;
    }

    public boolean listaVacia() {
        return inicio==null;
    }

}
