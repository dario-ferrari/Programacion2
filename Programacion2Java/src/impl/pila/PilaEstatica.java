package impl.pila;
import interfaces.PilaTDA;

/**
 * Implementación simple del TDA de una Pila Estática; al desapilar no se eliminan realmente los elementos de la Pila,
 * sino que simplemente se reduce en 1 el contador de la misma, con lo cual el método de tope devuelve el elemento
 * anterior del TDA como si se hubiera eliminado un elemento, pero éste sigue estando en memoria.
 */
public class PilaEstatica implements PilaTDA {

    private int[] pila;
    private int tam;

    @Override
    public void inicializarPila() {
        pila = new int[100];
        tam = 0;
    }

    @Override
    public void apilar(int elemento) {
        pila[tam] = elemento;
        tam++;
    }

    @Override
    public void desapilar() {
        --tam;
    }

    @Override
    public int tope() {
        return pila[tam-1];
    }

    @Override
    public boolean vacio() {
        return tam == 0;
    }
}
