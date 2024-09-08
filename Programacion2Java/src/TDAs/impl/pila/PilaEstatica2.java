package TDAs.impl.pila;
import TDAs.api.PilaTDA;
import java.util.Scanner;

/**
 * Implementación similar a la Pila Estática 1, se modifica que el usuario ingrese por teclado la cantidad de
 * elementos que va a tener la pila, y el hecho de que se eliminan los elementos desapilados (se tornan a 0).
 */
public class PilaEstatica2 implements PilaTDA {

    Scanner cantElement = new Scanner(System.in);
    private int[] pila;
    private int tam;

    @Override
    public void inicializarPila() {
        System.out.println("Cantidad de elementos de la Pila Estática: ");
        pila = new int[cantElement.nextInt()];
    }

    @Override
    public void apilar(int elemento) {
        pila[tam] = elemento;
        tam++;
    }

    @Override
    public void desapilar() {
        pila[tam - 1] = 0;
        tam--;
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
