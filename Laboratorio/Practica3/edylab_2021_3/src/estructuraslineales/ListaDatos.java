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

    /**
     * Compara la lista actual con una segunda lista
     * @param listaDatos2 La lista con la que se va a comparar
     * @return true si la lista actual es igual a la lista2
     */
    public boolean esIgual(Object listaDatos2);

    /**
     * Modifica un elemento que se quiere
     * @param elementoViejo Dato a cambiar
     * @param elementoNuevo Dato por el cual se cambiara
     * @param numVeces numero de ocurrencias
     * @return true si se cambio el dato, false en caso contrario
     */
    public boolean cambiar(Object elementoViejo, Object elementoNuevo, int numVeces);

    /**
     * Busca valores igual al parametro
     * @param elemento Parametro a igualar
     * @return Un arregloDatos con los valores agregados
     */
    public ArregloDatos buscarValores(Object elemento);

    /**
     * vacia la lista
     */
    public void vaciar();

    /**
     * Agrega los datos de la lista pasada como parametro a la lista actual
     * @param listaDatos2 Objeto que se evaluara para agregar los datos al arreglo actual
     * @return true si se agregan todos los datos, false en caso contrario
     */
    public boolean agregarLista(Object listaDatos2);

    /**
     * Invierte el orden de los elementos de la lista
     */
    public void invertir();

    /**
     * Cuenta cuantos datos igual al elemento se encontraron
     * @param elemento Es el valor espesificado por info
     * @return el numero de veces que se encontro
     */
    public int contar(Object elemento);

    /**
     * Elimina los datos que tienen en comun la lista actual y lista2
     * @param listaDatos2 Lista que contiene los elementos a eliminar
     * @return true si se eliminaron, false en caso contrario
     */
    public boolean eliminarLista(Object listaDatos2);

    /**
     * Agrega un elemento las veces indicadas
     * @param elemento El elemento que se va agregar
     * @param cantidad Las veces que se va agregar el elemento
     */
    public void rellenar(Object elemento, int cantidad);

    /**
     * Clona la lista actual
     * @return La nueva lista
     */
    public Object clonar();

    /**
     * Regresa una lista con los elementos indicados
     * @param indiceInicial Indica el inicio del rango
     * @param indiceFinal Indica el final del rango
     * @return Una lista
     */
    public Object subLista(int indiceInicial, int indiceFinal);
}
