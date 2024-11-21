package TDAs.impl.conjunto;

public class ConjuntoExtendido extends ConjuntoEstatico {

    private ConjuntoEstatico clonar(ConjuntoEstatico conjunto) {
        ConjuntoEstatico clon = new ConjuntoEstatico();
        clon.inicializarConjunto();

        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            clon.agregar(elemento);
            conjunto.sacar(elemento);
        }

        return clon;
    }

    public ConjuntoEstatico interseccion(ConjuntoEstatico otro) {
        ConjuntoEstatico resultado = new ConjuntoEstatico();
        resultado.inicializarConjunto();

        ConjuntoEstatico copiaActual = clonar(this);
        while (!copiaActual.conjuntoVacio()) {
            int elemento = copiaActual.elegir();
            if (otro.pertenece(elemento)) {
                resultado.agregar(elemento);
            }
            copiaActual.sacar(elemento);
        }

        return resultado;
    }

    public ConjuntoEstatico union(ConjuntoEstatico otro) {
        ConjuntoEstatico resultado = new ConjuntoEstatico();
        resultado.inicializarConjunto();

        ConjuntoEstatico copiaActual = clonar(this);
        while (!copiaActual.conjuntoVacio()) {
            int elemento = copiaActual.elegir();
            resultado.agregar(elemento);
            copiaActual.sacar(elemento);
        }

        ConjuntoEstatico copiaOtro = clonar(otro);
        while (!copiaOtro.conjuntoVacio()) {
            int elemento = copiaOtro.elegir();
            if (!resultado.pertenece(elemento)) {
                resultado.agregar(elemento);
            }
            copiaOtro.sacar(elemento);
        }

        return resultado;
    }

    public ConjuntoEstatico diferencia(ConjuntoEstatico otro) {
        ConjuntoEstatico resultado = new ConjuntoEstatico();
        resultado.inicializarConjunto();

        ConjuntoEstatico copiaActual = clonar(this);
        while (!copiaActual.conjuntoVacio()) {
            int elemento = copiaActual.elegir();
            if (!otro.pertenece(elemento)) {
                resultado.agregar(elemento);
            }
            copiaActual.sacar(elemento);
        }

        return resultado;
    }
}

