package TDAs.impl.colaPrioridad;

import TDAs.api.ColaPrioridadTDA;

public class ColaPrioridadDinamica implements ColaPrioridadTDA {

    class Nodo{
        //Creo el NODO (que va a ser el elemento, el cual tiene: dato, prioridad, y
        //la referencia al siguiente nodo.
        int dato, prior;
        Nodo sig;
    }

    private Nodo inicio;
    //Declaro el INICIO A LA LISTA (el cual es una referencia a un nodo).

    public void inicializarCola() {
        inicio=null;
    }

    public void acolarPrioridad(int x, int p) {
        //Elementos ordenados de mayor prioridad a menor prioridad.
        Nodo nuevo=new Nodo();
        //Creo un nodo nuevo.
        nuevo.dato=x;
        nuevo.prior=p;
        if (inicio==null) {//lista vacía.
            nuevo.sig=null;
            //(Esto es como poner el inicio en 0 creo.
            inicio=nuevo;
            return;
        }
        if(p>inicio.prior) {//Inserto elemento al inicio de la lista.
            nuevo.sig=inicio;
            //Hace referencia a la lista vieja.
            inicio =nuevo;
            //Enlazo el nodo.
            return;
        }
        Nodo corriente=inicio;
        //.. para hacer que no me quede el nodo en la primera posición creo. (08:37 AM cuando lo dijo en llamada. Mirar Clase 5).
        Nodo anterior=null;
        while(corriente!=null && p<=corriente.prior) {
            anterior=corriente;
            corriente=corriente.sig;
        }
        if (corriente==null) { //Si corriente es null significa que tengo que agregarlo al final.
            nuevo.sig=null;
            anterior.sig=nuevo;
            //Acá ya enlacé el nodo creo.
            return;
        }
        nuevo.sig=corriente; //Agregar entre nodos.
        anterior.sig=nuevo;
    }

    public void desacolar() {
        inicio=inicio.sig;
    }

    public int primero() {
        return inicio.dato;
    }

    public int prioridad() {
        return inicio.prior;
    }

    public boolean colaVacia() {
        return inicio==null;
    }

}
