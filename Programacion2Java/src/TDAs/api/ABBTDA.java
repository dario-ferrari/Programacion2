package TDAs.api;

/**
 * @ArbolDeBúsquedaBinaria es una colección de elementos ordenados en forma jerárquica (todos números enteros).
 * Entre dos elementos vinculados se define la relación padre-hijo. Cada elemento
 * tiene sólo un padre, excepto el elemento raíz del árbol que no tiene padre.
 * @author Dario Ferrari.
 *
 */

public interface ABBTDA {
    /**
     * @Tarea permite inicializar el árbol.
     */
    void inicializarABB();
    /**
     * @Tarea devuelve el valor de la raíz.
     * @Precondición el árbol no puede estar vacío.
     * @return
     */
    int raiz();
    /**
     * @Tarea devuelve la referencia al subárbol izquierdo. No elimina los elementos del subárbol.
     * @Precondición el árbol no puede estar vacío.
     * @return
     */
    ABBTDA hijoIzquierdo();
    /**
     * @Tarea devuelve la referencia al subárbol derecho. No elimina los elementos del subárbol.
     * @Precondición el árbol no puede estar vacío.
     * @return
     */
    ABBTDA hijoDerecho();
    /**
     * @Tarea agrega un valor suministrado.
     * @Precondición el árbol debe estar inicializado y NO debe existir el valor.
     * @param x
     */
    void agregar(int x);
    /**
     * @Tarea elimina un valor suministrado X.
     * @Precondición el valor debe existir.
     * @param x
     */
    void eliminar(int x);
    /**
     * @Tarea Devuelve TRUE si el árbol NO contiene elementos.
     * @Precondición el árbol debe estar inicializado.
     * @return
     */
    boolean arbolVacio();
    /**
     * @Tarea devuelve TRUE si el valor suministrado X pertenece al árbol.
     * @Precondición el árbol debe estar inicializado.
     * @param x
     * @return
     */
    boolean pertenece(int x);

}