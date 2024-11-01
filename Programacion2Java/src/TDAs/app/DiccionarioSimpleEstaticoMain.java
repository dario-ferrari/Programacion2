package TDAs.app;

import TDAs.api.DiccionarioSimpleTDA;
import TDAs.impl.diccionarioSimple.DiccionarioSimpleEstatico;

public class DiccionarioSimpleEstaticoMain {
    public static void main(String[] args) {
        pruebaDiccionario();
    }

    private static void pruebaDiccionario() {
        DiccionarioSimpleTDA diccionario = new DiccionarioSimpleEstatico();
        diccionario.InicializarDiccionario();
        diccionario.Agregar(1, 5);
        diccionario.Agregar(2, 6);
        diccionario.Agregar(3, 7);
        diccionario.Agregar(4, 8);
    }
}
