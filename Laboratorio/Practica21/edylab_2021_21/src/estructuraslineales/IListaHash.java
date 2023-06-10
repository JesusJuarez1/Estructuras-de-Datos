package estructuraslineales;

import estructurasnolineales.Tabla2D;

/**
 * Esta interface administra las operaciones sobre las ListasLigadasHash
 * @author Jesus Juarez
 * @version 1.0
 */
public interface IListaHash {

    /**
     * Evalua si la lista esta vacia
     * @return true si la lista esta vacia, false en caso contrario
     */
    public boolean vacia();

    /**
     * Inserta un elemento al final de la lista, cambia el valor si existe una clave repetida
     * @param clave clave que tendra el nuevo nodo de la lista
     * @param valor Valor que tendra el nuevo nodo de la lista
     * @return true si lo inserta, false en caso contrario
     */
    public boolean insertar(Object clave, Object valor);

    /**
     * Elimina un dato de la lista por la clave que tenga
     * @param clave Clave la cual identifica el valor que se va a eliminar
     * @return El elemento borrado, null en caso que no lo encontrara
     */
    public Object eliminar(Object clave);

    /**
     * Elimina un dato de la lista por el valor que tenga
     * @param valor valor que se quiere eliminar
     * @return El elemento borrado, null en caso que no lo encontrara
     */
    public Object eliminarValor(Object valor);

    /**
     * Busca un elemento de la lista por la clave
     * @param clave clave a buscar en la lista
     * @return El valor que tiene el elemento encontrado, null en caso que no lohaya encontrado
     */
    public Object buscar(Object clave);

    /**
     * Busca un elemento en la lista por el valor
     * @param valor Valor a buscar en la lista
     * @return El valor encontrado, null si no encontro el elemento
     */
    public Object buscarValor(Object valor);

    /**
     * Sustituye un valor de la lista buscando por la clave que tine
     * @param clave      Clave que tiene el elemento que se quiere sustituir
     * @param valorNuevo Nuevo valor a cambiar
     * @return true si lo cambio, false en caso contrario
     */
    public boolean substituir(Object clave, Object valorNuevo);

    /**
     * Sustituye un valor de la lista buscando por el valor que tiene
     * @param valor      Valor que tiene el elemento actual
     * @param valorNuevo valor por el cual se va a cambiar el elemento actual
     * @return true si lo encontro, false en caso contrario
     */
    public boolean substituirValor(Object valor, Object valorNuevo);

    /**
     * Imprime la lista
     */
    public void imprimir();

    /**
     * Imprime las claves que tiene de la lista
     */
    public void imprimirClaves();

    /**
     * Imprime los valores que contiene la lista
     */
    public void imprimirValores();

    /**
     * Agrega las claves a un arreglo y los valores a otro arreglo y estos arreglos los agrega una lista ligada
     * @return La lista ligada, null en caso que no lo hiciera
     */
    public ListaEncadenada aArreglos();

    /**
     * Agrega las claves de la lista a una lista ligada y los valores de la lista a otra lista ligada, y estas listas las agrega a otra lista
     * @return La lista ligada, null en caso que no lo hiciera
     */
    public ListaEncadenada aListas();

    /**
     * Agrega la lista a una matriz, donde en una columna agrega las claves y en ptra columna agrega los valores
     * @return la matriz, null en caso que no lo hiciera
     */
    public Tabla2D aTabla();

    /**
     * Vacia la lista
     */
    public void vaciar();

    /**
     * Obtiene un elemento de la lista por la clave
     * @param clave clave la cual identifica el elemento de la lista
     * @return El valor que contiene, null en caso que no lo encontrara
     */
    public Object obtener(Object clave);

    /**
     * Agrega todos los elementos de la lista2 a la lista actual
     * @param lista2 lista la cual contiene los elementos a agregar
     * @return true si los agrega, false en caso contrario
     */
    public boolean agregarLista(ListaEncadenadaHash lista2);

    /**
     * Obtiene la longitud de la list
     * @return la longitud de la lista
     */
    public int cantidadElementos();

    /**
     * Agrega a la lista actual las claves y los valores que contienen los arreglos paralelos
     * @param arregloClaves  Arreglo que contiene las claves
     * @param arregloValores Arreglo que contiene los valores
     * @return true si los agrego, false en caso contrario
     */
    public boolean agregarArreglos(ArregloDatos arregloClaves, ArregloDatos arregloValores);

    /**
     * Agrega a la lista actual las claves y los valores que contienen las listas paralelas
     * @param listaClaves  Lista que contiene las claves
     * @param listaValores Lista que contiene los valores
     * @return true si lo agrego, false en caso contrario
     */
    public boolean agregarListas(ListaEncadenada listaClaves, ListaEncadenada listaValores);

    /**
     * Agrega los datos de la matriz a la lista actual, la primera columna son las claves y la segunda los valores
     * @param tabla Matriz que contiene los datos a agregar
     * @return true si lo hizo, false en caso contrario
     */
    public boolean agregarTabla(Tabla2D tabla);
}
