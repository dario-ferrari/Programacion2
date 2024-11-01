package Ejercicios.Ejercicio4;

import TDAs.api.ColaTDA;
import TDAs.impl.cola.ColaEstatica;
import TDAs.impl.cola.ColaEstatica2;
import TDAs.util.PopuladorCola;

public class Ejercicio4A {
    public static void main(String[] args) {
        ColaTDA cola = new ColaEstatica2();
        cola.inicializarCola();

        PopuladorCola populador = new PopuladorCola();
        cola = populador.llenarCola(cola);

        ColaTDA copia = copiarCola(cola);
        System.out.println("Contenido de Cola copiada:");
        populador.imprimirCola(copia);
    }

    private static ColaTDA copiarCola(ColaTDA cola) {
        ColaTDA copia = new ColaEstatica();
        copia.inicializarCola();
        while(!cola.colaVacia()){
            copia.acolar(cola.primero());
            cola.desacolar();
        }
        return copia;
    }
}
