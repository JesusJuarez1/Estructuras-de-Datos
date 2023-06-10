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

    /**
     * Busca en el arreglo el elemento requerido
     * @param elemento elemento a buscar
     * @return la posicion en la que lo encontro, null en caso que no lo encontrara
     */
    public Object buscar(Object elemento);

    /**
     * Elimina el dato solicitado del arreglo
     * @param elemento elemento a borrar
     * @return el elemento que elimino, null en caso que no haya eliminado nada
     */
    public Object eliminar(Object elemento);

    /**
     * Elimina el ultimo dato que existe
     * @return El elemento eliminado, null en caso que no lo haya echo
     */
    public Object eliminar();

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

    /**
     * Rellena dependiendo si es un numero, letra o un objeto
     * @param elemento elemento con el que se rellenara el arreglo
     */
    public void rellenar(Object elemento);

    /**
     * Indica si la lista pasada como parametro es sublista de la lista actual
     * @param listaDatos2 lista a comparar
     * @return true si lo es, false en caso contrario
     */
    public boolean esSublista(Object listaDatos2);

    /**
     * Cambia los datos en comun de la lista actual y la listaDatos2 y lo cambia por el elemento que esta en listaDatos2Nuevos
     * @param listaDatos2 Contiene los elementos que se quieren cambiar
     * @param listaDatos2Nuevos Contiene los elementos por los cuales se cambiaran
     * @return true si lo hizo, flase en caso contrario
     */
    public boolean cambiarLista(ArregloDatos listaDatos2,ArregloDatos listaDatos2Nuevos);

    /**
     * Deja en la lista actual solo los elementos que se encuentran en listaDatos2
     * @param listaDatos2 Lista con los datos que se quieren dejar
     * @return true si lo hace, false en caso contrario
     */
    public boolean retenerLista(ArregloDatos listaDatos2);

    /**
     * Inserta en la posicion indicada el elemento
     * @param indice indice donde se va colocar el elemento
     * @param elemento elemento a colocar
     * @return true si lo hace, false en caso contrario
     */
    public boolean insertar(int indice, Object elemento);

    /**
     * Agrega los datos de la lista a la lista actual quitando los anteriores
     * @param listaDatos2 lista a agregar
     * @return true si lo hace, false en caso contrario
     */
    public boolean copiarLista(ArregloDatos listaDatos2);
}
