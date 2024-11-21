package TP3.Ejercicio5;

import TDAs.api.DiccionarioMultipleTDA;
import TDAs.impl.diccionarioMultiple.DiccionarioMultipleDinamico;
import TDAs.api.ConjuntoTDA;

public class Ejercicio5D {
    public static void main(String[] args) {
        DiccionarioMultipleTDA D1 = new DiccionarioMultipleDinamico();
        DiccionarioMultipleTDA D2 = new DiccionarioMultipleDinamico();

        D1.inicializarDiccionario();
        D2.inicializarDiccionario();

        D1.agregar(1, 10);
        D1.agregar(1, 20);
        D1.agregar(1, 30);
        D1.agregar(2, 40);
        D1.agregar(2, 50);

        D2.agregar(1, 30);
        D2.agregar(1, 40);
        D2.agregar(3, 60);
        D2.agregar(3, 70);

        DiccionarioMultipleTDA resultado = clavesComunesConElementosComunes(D1, D2);
        imprimirDiccionario(resultado);
    }

    public static DiccionarioMultipleTDA clavesComunesConElementosComunes(DiccionarioMultipleTDA D1, DiccionarioMultipleTDA D2) {
        DiccionarioMultipleTDA resultado = new DiccionarioMultipleDinamico();
        resultado.inicializarDiccionario();

        ConjuntoTDA clavesD1 = D1.claves();
        ConjuntoTDA clavesD2 = D2.claves();

        while (!clavesD1.conjuntoVacio()) {
            int clave = clavesD1.elegir();
            if (clavesD2.pertenece(clave)) {
                int[] valoresD1 = D1.recuperar(clave);
                int[] valoresD2 = D2.recuperar(clave);
                int[] valoresComunes = intersecar(valoresD1, valoresD2);

                for (int valor : valoresComunes) {
                    resultado.agregar(clave, valor);
                }
            }
            clavesD1.sacar(clave);
        }

        return resultado;
    }

    private static int[] intersecar(int[] valoresD1, int[] valoresD2) {
        java.util.Set<Integer> setD1 = new java.util.HashSet<>();
        for (int valor : valoresD1) {
            setD1.add(valor);
        }

        java.util.Set<Integer> interseccion = new java.util.HashSet<>();
        for (int valor : valoresD2) {
            if (setD1.contains(valor)) {
                interseccion.add(valor);
            }
        }

        int[] resultado = new int[interseccion.size()];
        int i = 0;
        for (int valor : interseccion) {
            resultado[i++] = valor;
        }

        return resultado;
    }

    private static void imprimirDiccionario(DiccionarioMultipleTDA diccionario) {
        ConjuntoTDA claves = diccionario.claves();
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            int[] valores = diccionario.recuperar(clave);
            System.out.println("Clave: " + clave + ", Valores: " + java.util.Arrays.toString(valores));
            claves.sacar(clave);
        }
    }
}
