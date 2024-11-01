package TDAs.impl.diccionarioMultiple;

import TDAs.api.ConjuntoTDA;
import TDAs.api.DiccionarioMultipleTDA;
import TDAs.impl.conjunto.ConjuntoEstatico;

public class DiccionarioMultipleEstatico implements DiccionarioMultipleTDA {

    private class Elemento {
        int clave;
        int posLibre;
        int[]valores;
        ConjuntoTDA conjuntoValores=new ConjuntoEstatico();
    }

    private Elemento[]vector;
    //vector es el diccionario que contiene una cantidad N de elementos, cada uno con una clave única y un vector
    //con una lista de valores únicos asociados a esa clave.
    private int cant;
    private int[]cantValores;
    private ConjuntoTDA conjuntoClaves=new ConjuntoEstatico();

    public void inicializarDiccionario() {
        vector=new Elemento[100];
        cant=0;
        conjuntoClaves.inicializarConjunto();
        cantValores=new int[100];
    }

    public void agregar(int clave, int x) {
        if (conjuntoClaves.pertenece(clave)==false) {
            Elemento nuevo=new Elemento();
            nuevo.clave=clave;
            nuevo.conjuntoValores.inicializarConjunto();
            nuevo.valores=new int[100];
            nuevo.posLibre=0;
            if(nuevo.conjuntoValores.pertenece(x)==false) {
                nuevo.valores[nuevo.posLibre]=x;
                nuevo.posLibre++;
                nuevo.conjuntoValores.agregar(x);
            }
            conjuntoClaves.agregar(clave);
            vector[cant]=nuevo;
            cant++;
            cantValores[cant-1]=nuevo.posLibre;
        }
        else {
            int cont=0;
            int cont2=cant;
            while(cont2>0) {
                if(vector[cont].clave==clave) {
                    vector[cont].valores[vector[cont].posLibre]=x;
                    vector[cont].posLibre++;
                    vector[cont].conjuntoValores.inicializarConjunto();
                    vector[cont].conjuntoValores.agregar(x);
                }
                cont2--;
            }
        }
    }

    public void eliminar(int clave) {
        if (conjuntoClaves.pertenece(clave)==true) {
            int cont=0;
            int cont2=cant;
            while(cont2>0) {
                int cl=vector[cont].clave;
                if (cl==clave) {
                    vector[cant]=vector[cont];
                    int cont3=cont;
                    int cont4=cont;
                    while (cont3<cant){
                        vector[cont4]=vector[cont4+1];
                        cont3++;
                        cont4++;
                    }
                }
                cont++;
                cont2--;
            }
            cant--;
            conjuntoClaves.sacar(clave);
        }
    }

    public void eliminarValor(int clave, int x) {
        //Este método primero busca la clave suministrada dentro del diccionario, una vez que la encuentra,
        //busca el valor suministrado dentro del vector de valores que está asociado a la clave. Una vez que
        //encuentra el valor, lo corre a la última posición del vector y lo elimina.
        if (conjuntoClaves.pertenece(clave)==true) {//Si la clave existe, entra a la iteración.
            int cont=0;
            int cont2=cant;
            while (cont2>0) {
                int cl=vector[cont].clave;
                if (cl==clave) {//Encuentra la clave.
                    if (vector[cont].conjuntoValores.pertenece(x)==true) {//Si el valor existe en esa clave, entra a la iteración.
                        int cont3=0;
                        int cont4=vector[cont].posLibre;
                        while(cont4>0) {
                            if (vector[cont].valores[cont3]==x) {//Encuentra el valor.
                                vector[cont].valores[vector[cont].posLibre]=vector[cont].valores[cont3];
                                int cont5=cont3;
                                int cont6=cont3;
                                while(cont5<vector[cont].posLibre) {
                                    vector[cont].valores[cont6]=vector[cont].valores[cont6+1];
                                    cont5++;
                                    cont6++;
                                }
                            }
                            cont3++;
                            cont4--;
                        }
                        vector[cont].posLibre--;//Elimina el valor.
                        vector[cont].conjuntoValores.sacar(x);
                    }
                }
                cont++;
                cont2--;
            }
        }
    }

    public int[] recuperar(int clave) {
        if (conjuntoClaves.pertenece(clave)==false) {
            return null;
        }
        int cont=0;
        while(vector[cont].clave!=clave) {
            cont++;
        }
        int[] vlr=vector[cont].valores;
        return vlr;
    }

    public ConjuntoTDA claves() {
        return conjuntoClaves;
    }
}
