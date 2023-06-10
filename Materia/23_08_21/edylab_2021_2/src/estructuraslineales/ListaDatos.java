package estructuraslineales;

/**
 * Esta interface administra la funcionalidad de una lista de datos.
 * @author Clase de ED.
 * @version 1.0
 */
public interface ListaDatos {

    /**
     * Determina si una lista de datos esta vacia.
     * @return Regresa <b>true</b> si la lista esta vacia, <b>false</b> en caso contrario.
     */
    public boolean vacia();

    /**
     * Inserta al final de la lista un elemento proporcionado.
     * @param elemento Es el dato que se desea agregar a la lista.
     * @return Regresa la posicion de memoria (indice) en donde se agrega el elemento, o -1 en caso contrario.
     */

    public int agregar(Object elemento);

    public void imprimir();

    public void imprimirOrdenInverso();

    public Object buscar(Object elemento);

    public Object eliminar(Object elemento);
}
