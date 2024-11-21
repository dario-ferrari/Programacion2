package TP1.Ejercicios.Ejercicio4;

import TDAs.api.ColaTDA;
import TDAs.impl.cola.ColaEstatica2;
import TDAs.util.PopuladorCola;

/**
 * 4)D) Determinar si el final de la Cola C1 coincide o no con la Cola C2.
 */
public class Ejercicio4D {
    public static void main(String[] args) {
        PopuladorCola populador = new PopuladorCola();

        ColaTDA c1 = new ColaEstatica2();
        c1.inicializarCola();
        c1 = populador.llenarCola(c1);
        int cantElementosCola = populador.cantElementos();

        ColaTDA c2 = new ColaEstatica2();
        c2.inicializarCola();
        c2= populador.llenarCola(c2);
        int cantElementosCola2 = populador.cantElementos();

        boolean comparadas = compararFinal(c1, c2, cantElementosCola, cantElementosCola2);

        if (comparadas) {
            System.out.println("Ambas colas tienen el mismo último elemento.");
        } else {
            System.out.println("Ambas colas son diferentes en su último elemento.");
        }

    }

    private static boolean compararFinal(ColaTDA cola, ColaTDA cola2, int elementosCola, int elementosCola2) {
        while(!cola.colaVacia()) {
            if(elementosCola==1) {
                while(!cola2.colaVacia()) {
                    if(elementosCola2==1) {
                        return cola.primero()==cola2.primero();
                    }
                    cola2.desacolar();
                    elementosCola2--;
                }
            }
            cola.desacolar();
            elementosCola--;
        }
        return false;
    }
}
