package TP3.Ejercicio5B;

import TDAs.api.DiccionarioMultipleTDA;
import TDAs.impl.diccionarioMultiple.DiccionarioMultipleDinamico;
import TDAs.api.DiccionarioSimpleTDA;
import TDAs.impl.diccionarioSimple.DiccionarioSimpleDinamico;
import TDAs.api.ConjuntoTDA;

public class Ejercicio5B1 {

    /**
     * REVISAR!!!!
     */

    /**public static void main(String[] args) {
        DiccionarioSimpleTDA D = new DiccionarioSimpleDinamico();
        DiccionarioMultipleTDA DS = new DiccionarioMultipleDinamico();

        D.InicializarDiccionario();
        DS.inicializarDiccionario();

        D.Agregar("perro", "animal");
        D.Agregar("gato", "animal");
        D.Agregar("mesa", "mueble");
        D.Agregar("silla", "mueble");

        generarDiccionarioMultiple(D, DS);
        imprimirDiccionario(DS);
    }

    public static void generarDiccionarioMultiple(DiccionarioSimpleTDA D, DiccionarioMultipleTDA DS) {
        ConjuntoTDA clavesD = D.Claves();

        while (!clavesD.conjuntoVacio()) {
            String palabra = clavesD.elegir();
            String significado = D.Recuperar(palabra);

            if (DS.claves().pertenece(significado)) {
                DS.agregar(significado, palabra);
            } else {
                DS.agregar(significado, new String[]{palabra});
            }

            clavesD.sacar(palabra);
        }
    }

    private static void imprimirDiccionario(DiccionarioMultipleTDA diccionario) {
        ConjuntoTDA claves = diccionario.claves();
        while (!claves.conjuntoVacio()) {
            String clave = claves.elegir();
            String[] valores = diccionario.recuperar(clave);
            System.out.println("Clave: " + clave + ", Valores: " + java.util.Arrays.toString(valores));
            claves.sacar(clave);
        }
    }**/
}
