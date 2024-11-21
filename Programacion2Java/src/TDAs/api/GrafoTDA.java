package TDAs.api;

public interface GrafoTDA {

    void inicializarGrafo();
    void agregarVertice(int vertice);
    void eliminarVertice(int vertice);
    void agregarArista(int v1, int v2, int p);
    void eliminarArista(int v1, int v2);
    int pesoArista(int v1, int v2);
    ConjuntoTDA vertices();
    boolean existeArista(int v1, int v2);

}