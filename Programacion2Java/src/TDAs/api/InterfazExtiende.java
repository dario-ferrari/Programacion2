package TDAs.api;

/**
 * De esta forma agrego un nuevo método a la interfaz ya existente; esta interfaz va a tener todos los métodos de
 * ColaPrioridadTDA más los que yo le sume acá; de esta forma puedo agregar métodos nuevos a una interfaz ya existente
 * sin la necesidad de editar la interfaz original.
 */
public interface InterfazExtiende extends ColaPrioridadTDA {
    int prueba();
}
