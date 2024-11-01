package TDAs.impl.diccionarioSimple;

import TDAs.api.ConjuntoTDA;
import TDAs.api.DiccionarioSimpleTDA;
import TDAs.impl.conjunto.ConjuntoEstatico;

public class DiccionarioSimpleEstatico implements DiccionarioSimpleTDA {

    private class Elemento {
        int clave, valor;
    }
    private Elemento[]vector;
    private int cant;
    private ConjuntoTDA listaClaves = new ConjuntoEstatico();

    public void InicializarDiccionario() {
        vector = new Elemento[100];
        cant = 0;
        listaClaves.inicializarConjunto();
    }

    public void Agregar(int clave, int valor) {
        Elemento nuevo=new Elemento();
        nuevo.clave=clave;
        nuevo.valor=valor;
        if (!listaClaves.pertenece(clave)) {
            listaClaves.agregar(clave);
            vector[cant]=nuevo;
            cant++;
        }
        else {
            vector[cant]=nuevo;
            cant++;
        }
    }

    public void Eliminar(int clave) {
        if (listaClaves.pertenece(clave)) {
            int cont = 0;
            int cont2 = cant;
            while (cont2 > 0) {
                Elemento i = vector[cont];
                int cl = i.clave;
                if (cl == clave) {
                    vector[cant] = i;
                    int cont3 = cont;
                    int cont4 = cont;
                    while (cont3 < cant) {
                        vector[cont4] = vector[cont4 + 1];
                        cont3++;
                        cont4++;
                    }
                }
                cont++;
                cont2--;
            }
            cant--;
            listaClaves.sacar(clave);
        }
    }

    public int Recuperar(int clave) {
        if(!listaClaves.pertenece(clave)) {
            return 0;
        }
        int cont=0;
        while(vector[cont].clave!=clave) {
            cont++;
        }
        int v = vector[cont].valor;
        return v;
    }

    public ConjuntoTDA Claves() {
        return listaClaves;
    }
}
