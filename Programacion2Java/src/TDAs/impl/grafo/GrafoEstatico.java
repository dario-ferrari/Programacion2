package TDAs.impl.grafo;

import TDAs.api.ConjuntoTDA;
import TDAs.api.GrafoTDA;
import TDAs.impl.conjunto.ConjuntoEstatico;

public class GrafoEstatico implements GrafoTDA {

    private int n=100;
    private int [][] MAdy;
    int [] etiqs;
    int cantNodos;

    public void inicializarGrafo() {
        MAdy=new int[n][n];
        etiqs=new int[n];
        cantNodos=0;
    }

    public void agregarVertice(int vertice) {
        etiqs[cantNodos]=vertice;
        for (int i=0; i<=cantNodos; i++) {
            MAdy[cantNodos][i]=0;
            MAdy[i][cantNodos]=0;
        }
        cantNodos++;
    }

    private int Vert2Indice(int vertice) {
        int i=cantNodos-1;
        while(i>=0 && etiqs[i]!=vertice) {
            i--;
        }
        return i;
    }

    public void eliminarVertice(int vertice) {
        int indice=Vert2Indice(vertice);
        for (int i=0;i<cantNodos;i++) {
            MAdy[i][indice]=MAdy[i][cantNodos-1];
        }
        for (int i=0; i<cantNodos; i++) {
            MAdy[indice][i]=MAdy[cantNodos-1][i];
        }
        etiqs[indice]=etiqs[cantNodos-1];
        cantNodos--;
    }

    public void agregarArista(int v1, int v2, int p) {
        int o=Vert2Indice(v1);
        int d=Vert2Indice(v2);
        MAdy[o][d]=p;
    }

    public void eliminarArista(int v1, int v2) {
        int o=Vert2Indice(v1);
        int d=Vert2Indice(v2);
        MAdy[o][d]=0;
    }

    public int pesoArista(int v1, int v2) {
        int o=Vert2Indice(v1);
        int d=Vert2Indice(v2);
        return MAdy[o][d];
    }

    public ConjuntoTDA vertices() {
        ConjuntoTDA Vert=new ConjuntoEstatico();
        Vert.inicializarConjunto();
        for (int i=0; i<cantNodos; i++) {
            Vert.agregar(etiqs[i]);
        }
        return Vert;
    }

    public boolean existeArista(int v1, int v2) {
        int o=Vert2Indice(v1);
        int d=Vert2Indice(v2);
        return (MAdy[o][d]!=0);
    }

}
