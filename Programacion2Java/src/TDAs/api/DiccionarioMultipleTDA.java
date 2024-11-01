package TDAs.api;

public interface DiccionarioMultipleTDA {

    void inicializarDiccionario();

    void agregar(int clave, int valor);

    void eliminar(int clave);

    void eliminarValor(int clave, int valor);

    int[] recuperar(int clave);

    ConjuntoTDA claves();
}
