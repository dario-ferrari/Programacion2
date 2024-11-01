package TDAs.api;

public interface ColaTDA {

    void inicializarCola();

    void acolar(int elemento);

    void desacolar();

    int primero();

    boolean colaVacia();
}
