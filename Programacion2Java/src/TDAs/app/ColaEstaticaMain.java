package TDAs.app;

import TDAs.impl.cola.ColaEstatica;
import TDAs.api.ColaTDA;

public class ColaEstaticaMain {

    public static void main(String[] args) {
        cola1();
    }

    private static void cola1() {
        ColaTDA colaEstatica = new ColaEstatica();
        colaEstatica.inicializarCola();
        colaEstatica.acolar(1);
        colaEstatica.acolar(2);
        colaEstatica.acolar(3);
        colaEstatica.acolar(4);

        System.out.print("Contenido de la Cola: ");
        while (!colaEstatica.colaVacia()){
            System.out.print(colaEstatica.primero());
            colaEstatica.desacolar();
        }
    }


}
