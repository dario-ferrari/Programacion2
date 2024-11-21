package TDAs.impl.grafo;

import TDAs.api.ConjuntoTDA;
import TDAs.api.GrafoTDA;
import TDAs.impl.conjunto.ConjuntoDinamico;

public class GrafoDinamico implements GrafoTDA {

    class NodoGrafo {
        int nodo;
        NodoArista arista;
        NodoGrafo sigNodo;
    }

    class NodoArista {
        int etiqueta;
        NodoGrafo nodoDestino;
        NodoArista sigArista;
    }

    private NodoGrafo origen;

    public void inicializarGrafo() {
        origen = null;
    }

    public void agregarVertice(int vertice) {
        NodoGrafo aux = new NodoGrafo();
        aux.nodo = vertice;
        aux.arista = null;
        aux.sigNodo = origen;
        origen = aux;
    }

    private NodoGrafo Vert2Nodo(int vertice) {
        NodoGrafo aux = origen;
        while (aux != null && aux.nodo != vertice)
            aux = aux.sigNodo;
        return aux;
    }

    public void eliminarVertice(int v) {
        if (origen.nodo == v)
            origen = origen.sigNodo;
        NodoGrafo aux = origen;
        while (aux != null) {
            this.EliminarAristaNodo(aux, v);
            if (aux.sigNodo != null && aux.sigNodo.nodo == v)
                aux.sigNodo = aux.sigNodo.sigNodo;
            aux = aux.sigNodo;
        }
    }

    public void agregarArista(int v1, int v2, int peso) {
        NodoGrafo n1 = Vert2Nodo(v1);
        NodoGrafo n2 = Vert2Nodo(v2);
        NodoArista aux = new NodoArista();
        aux.etiqueta = peso;
        aux.nodoDestino = n2;
        aux.sigArista = n1.arista;
        n1.arista = aux;
    }

    private void EliminarAristaNodo(NodoGrafo nodo, int v) {
        NodoArista aux = nodo.arista;
        if (aux != null) {
            if (aux.nodoDestino.nodo == v) {
                nodo.arista = aux.sigArista;
            } else {
                while (aux.sigArista != null && aux.sigArista.nodoDestino.nodo != v)
                    aux = aux.sigArista;
                if (aux.sigArista != null) {
                    aux.sigArista = aux.sigArista.sigArista;
                }
            }
        }
    }

    public void eliminarArista(int v1, int v2) {
        NodoGrafo n1 = Vert2Nodo(v1);
        EliminarAristaNodo(n1, v2);
    }

    public int pesoArista(int v1, int v2) {
        NodoGrafo n1 = Vert2Nodo(v1);
        NodoArista aux = n1.arista;
        while (aux.nodoDestino.nodo != v2)
            aux = aux.sigArista;
        return aux.etiqueta;
    }

    public ConjuntoTDA vertices() {
        ConjuntoTDA c = new ConjuntoDinamico();
        c.inicializarConjunto();
        NodoGrafo aux = origen;
        while (aux != null) {
            c.agregar(aux.nodo);
            aux = aux.sigNodo;
        }
        return c;
    }

    public boolean existeArista(int v1, int v2) {
        NodoGrafo n1 = Vert2Nodo(v1);
        NodoArista aux = n1.arista;
        while (aux != null && aux.nodoDestino.nodo != v2)
            aux = aux.sigArista;
        return (aux != null);
    }
}