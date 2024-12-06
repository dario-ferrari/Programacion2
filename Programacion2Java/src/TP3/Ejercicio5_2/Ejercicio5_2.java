package TP3.Ejercicio5_2;

import TDAs.api.ConjuntoTDA;
import TDAs.api.DiccionarioMultipleTDA;
import TDAs.api.DiccionarioSimpleTDA;
import TDAs.impl.diccionarioMultiple.DiccionarioMultipleEstatico;
import TDAs.impl.diccionarioSimple.DiccionarioSimpleEstatico;

public class Ejercicio5_2 {

    public static void main(String[] args) {
        DiccionarioSimpleTDA diccionarioSimple = new DiccionarioSimpleEstatico();
        diccionarioSimple.InicializarDiccionario();

        //agrego palabras (claves) y sus significados (valores)
        diccionarioSimple.Agregar(1, 100);
        diccionarioSimple.Agregar(2, 100);
        diccionarioSimple.Agregar(3, 200);
        diccionarioSimple.Agregar(4, 100);
        diccionarioSimple.Agregar(5, 300);

        //diccionario múltiple con sinónimos
        DiccionarioMultipleTDA diccionarioMultiple = generarDiccionarioMultiple(diccionarioSimple);

        imprimirDiccionarioMultiple(diccionarioMultiple);
    }

    /**
     * Genera un Diccionario Múltiple que relaciona significados con las palabras que comparten ese significado.
     */
    private static DiccionarioMultipleTDA generarDiccionarioMultiple(DiccionarioSimpleTDA diccionarioSimple) {
        DiccionarioMultipleTDA diccionarioMultiple = new DiccionarioMultipleEstatico();
        diccionarioMultiple.inicializarDiccionario();

        ConjuntoTDA claves = diccionarioSimple.Claves();

        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir(); //elijo una clave (palabra)
            claves.sacar(clave);

            int significado = diccionarioSimple.Recuperar(clave); //recupero el significado asociado a la clave

            diccionarioMultiple.agregar(significado, clave); //agrego la clave (palabra) al Diccionario Múltiple bajo el significado correspondiente
        }

        return diccionarioMultiple;
    }

    /**
     * Imprime un Diccionario Múltiple, mostrando cada significado y las palabras asociadas.
     */
    private static void imprimirDiccionarioMultiple(DiccionarioMultipleTDA diccionarioMultiple) {
        ConjuntoTDA claves = diccionarioMultiple.claves();

        while (!claves.conjuntoVacio()) {
            int significado = claves.elegir();
            claves.sacar(significado);

            int[] palabras = diccionarioMultiple.recuperar(significado); //recupero las palabras asociadas al significado

            System.out.print("Significado " + significado + ": ");
            for (int palabra : palabras) {
                System.out.print(palabra + " ");
            }
            System.out.println();
        }
    }
}