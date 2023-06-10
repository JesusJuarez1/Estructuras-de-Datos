package registros.basedatos;

/**
 * Clase la cual almacena un indice y una direccion
 * @author Jesus
 * @version 1.0
 */
public class NodoBusquedaBinaria {
    protected long indice;
    protected long direccion;

    public NodoBusquedaBinaria(long indice, long direccion) {
        this.indice = indice;
        this.direccion = direccion;
    }

    /**
     * Obtiene el indice que contiene el nodo
     * @return El indice del nodo
     */
    public long getIndice() {
        return indice;
    }

    /**
     * Obtiene la direccion del nodo
     * @return La direccion que contiene el nodo
     */
    public long getDireccion() {
        return direccion;
    }

    /**
     * Cambia el indice del nodo
     * @param indice Nuevo indice
     */
    public void setIndice(long indice) {
        this.indice = indice;
    }

    /**
     * Cambia la direccion del nodo
     * @param direccion Nueva direccion
     */
    public void setDireccion(long direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return ""+indice;
    }
}
