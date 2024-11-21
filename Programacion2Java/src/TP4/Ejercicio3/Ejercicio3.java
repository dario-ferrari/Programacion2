package TP4.Ejercicio3;

import TDAs.api.ABBTDA;
import TDAs.impl.abb.ArbolABB;

public class Ejercicio3 {
    public static void main(String[] args) {
        ABBTDA arbol = new ArbolABB();
        arbol.inicializarABB();

        arbol.agregar(10);
        arbol.agregar(5);
        arbol.agregar(15);
        arbol.agregar(3);
        arbol.agregar(7);

        System.out.println("¿El elemento 5 está en el ABB? " + perteneceRecursivo(arbol, 5));
        System.out.println("¿El elemento 8 está en el ABB? " + perteneceIterativo(arbol, 8));
    }

    public static boolean perteneceRecursivo(ABBTDA arbol, int x) {
        if (arbol.arbolVacio()) {
            return false;
        }
        if (arbol.raiz() == x) {
            return true;
        }
        if (x < arbol.raiz()) {
            return perteneceRecursivo(arbol.hijoIzquierdo(), x);
        } else {
            return perteneceRecursivo(arbol.hijoDerecho(), x);
        }
    }

    public static boolean perteneceIterativo(ABBTDA arbol, int x) {
        while (!arbol.arbolVacio()) {
            if (arbol.raiz() == x) {
                return true;
            } else if (x < arbol.raiz()) {
                arbol = arbol.hijoIzquierdo();
            } else {
                arbol = arbol.hijoDerecho();
            }
        }
        return false;
    }

    public static boolean esHojaRecursivo(ABBTDA arbol, int x) {
        if (arbol.arbolVacio()) {
            return false;
        }
        if (arbol.raiz() == x) {
            return arbol.hijoIzquierdo().arbolVacio() && arbol.hijoDerecho().arbolVacio();
        }
        if (x < arbol.raiz()) {
            return esHojaRecursivo(arbol.hijoIzquierdo(), x);
        } else {
            return esHojaRecursivo(arbol.hijoDerecho(), x);
        }
    }

    public static boolean esHojaIterativo(ABBTDA arbol, int x) {
        while (!arbol.arbolVacio()) {
            if (arbol.raiz() == x) {
                return arbol.hijoIzquierdo().arbolVacio() && arbol.hijoDerecho().arbolVacio();
            } else if (x < arbol.raiz()) {
                arbol = arbol.hijoIzquierdo();
            } else {
                arbol = arbol.hijoDerecho();
            }
        }
        return false;
    }

    public static int profundidadRecursiva(ABBTDA arbol, int x, int profundidad) {
        if (arbol.arbolVacio()) {
            return -1;
        }
        if (arbol.raiz() == x) {
            return profundidad;
        }
        if (x < arbol.raiz()) {
            return profundidadRecursiva(arbol.hijoIzquierdo(), x, profundidad + 1);
        } else {
            return profundidadRecursiva(arbol.hijoDerecho(), x, profundidad + 1);
        }
    }

    public static int profundidadIterativa(ABBTDA arbol, int x) {
        int profundidad = 0;
        while (!arbol.arbolVacio()) {
            if (arbol.raiz() == x) {
                return profundidad;
            } else if (x < arbol.raiz()) {
                arbol = arbol.hijoIzquierdo();
            } else {
                arbol = arbol.hijoDerecho();
            }
            profundidad++;
        }
        return -1;
    }

    public static int menorRecursivo(ABBTDA arbol) {
        if (arbol.hijoIzquierdo().arbolVacio()) {
            return arbol.raiz();
        } else {
            return menorRecursivo(arbol.hijoIzquierdo());
        }
    }

    public static int menorIterativo(ABBTDA arbol) {
        while (!arbol.hijoIzquierdo().arbolVacio()) {
            arbol = arbol.hijoIzquierdo();
        }
        return arbol.raiz();
    }

    public static int cantidadRecursiva(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        }
        return 1 + cantidadRecursiva(arbol.hijoIzquierdo()) + cantidadRecursiva(arbol.hijoDerecho());
    }

    public static int cantidadIterativa(ABBTDA arbol) {
        int cantidad = 0;
        while (!arbol.arbolVacio()) {
            cantidad++;
            if (!arbol.hijoIzquierdo().arbolVacio()) {
                arbol = arbol.hijoIzquierdo();
            } else {
                arbol = arbol.hijoDerecho();
            }
        }
        return cantidad;
    }

    public static int sumaRecursiva(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        }
        return arbol.raiz() + sumaRecursiva(arbol.hijoIzquierdo()) + sumaRecursiva(arbol.hijoDerecho());
    }

    public static int sumaIterativa(ABBTDA arbol) {
        int suma = 0;
        while (!arbol.arbolVacio()) {
            suma += arbol.raiz();
            if (!arbol.hijoIzquierdo().arbolVacio()) {
                arbol = arbol.hijoIzquierdo();
            } else {
                arbol = arbol.hijoDerecho();
            }
        }
        return suma;
    }

    public static int cantidadHojasRecursiva(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        }
        if (arbol.hijoIzquierdo().arbolVacio() && arbol.hijoDerecho().arbolVacio()) {
            return 1;
        }
        return cantidadHojasRecursiva(arbol.hijoIzquierdo()) + cantidadHojasRecursiva(arbol.hijoDerecho());
    }

    public static int cantidadHojasIterativa(ABBTDA arbol) {
        int cantidad = 0;
        while (!arbol.arbolVacio()) {
            if (arbol.hijoIzquierdo().arbolVacio() && arbol.hijoDerecho().arbolVacio()) {
                cantidad++;
            }
            if (!arbol.hijoIzquierdo().arbolVacio()) {
                arbol = arbol.hijoIzquierdo();
            } else {
                arbol = arbol.hijoDerecho();
            }
        }
        return cantidad;
    }

    public static int alturaRecursiva(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return -1;
        }
        int alturaIzquierda = alturaRecursiva(arbol.hijoIzquierdo());
        int alturaDerecha = alturaRecursiva(arbol.hijoDerecho());
        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    public static int alturaIterativa(ABBTDA arbol) {
        int altura = -1;
        return altura;
    }
}
