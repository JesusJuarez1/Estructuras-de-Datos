package estructuraslineales;

public interface VectorDatos extends ListaDatos{

    public boolean lleno();

    public int capacidad();

    public int cantidadElementos();

    /**
     * Obtiene un elemento buscandolo por el indice
     * @param indice el elemento que se desea buscar
     * @return El elemento que se encuentra, si no lo encuentra retorna null
     */
    public Object obtener(int indice);

    /**
     * Modifica un elemento de la lista en base al indice
     * @param indice Posicion que se va a cambiar
     * @param elemento Dato por el que se cambiara el registro
     * @return true si se cambio el dato, false en caso contrario
     */
    public boolean cambiar(int indice, Object elemento);

    /**
     * Cambia los datos por los datos almacenados en elementosNuevos, en las posiciones indicesBusqueda
     * @param indicesBusqueda Arreglo que contiene las posiciones
     * @param elementosNuevos Arreglo que contiene los datos por los que se cambiaran
     * @return true si lo hizo, false en caso de algun error
     */
    public boolean cambiarArregloDatos(ArregloDatos indicesBusqueda, ArregloDatos elementosNuevos);

    /**
     * Elimina un dato de la lista con el indice
     * @param indice dato de la lista
     * @return el objeto que se elimino, null en caso que no se eliminara
     */
    public Object eliminar(int indice);

    /**
     * Elimina el ultimo dato de la lista
     * @return regresa el valor eliminado.
     */
    public Object eliminar();

    /**
     * Redimenciona la lista
     * @param maximo Es la nueva dimension de la lista
     * @return La nueva lista redimensionada,Si el tamaño es menor, los elementos sobrantes deben ser eliminados. Si el tamaño es mayor, los datos anteriores deben conservarse
     */
    public Object redimensionar(int maximo);

    public Object verTope();
}
