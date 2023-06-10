package estructuraslineales.registros;

/**
 * Nodo que contrendra una clave unica, el valor que guardara y un apuntador derecho
 * @author Jesus
 * @version 1.0
 */
public class NodoHash {
    protected Object clave;
    protected Object valor;
    protected NodoHash dirMemDer;

    public NodoHash(Object clave, Object valor) {
        this.clave = clave;
        this.valor = valor;
        dirMemDer = null;
    }

    /**
     * Obtiene la clave del nodo
     * @return La clave del nodo
     */
    public Object getClave() {
        return clave;
    }

    /**
     * Obtiene el valor del nodo
     * @return El valor del nodo
     */
    public Object getValor() {
        return valor;
    }

    /**
     * Obtiene el apuntador derecho del nodo
     * @return El apuntador derecho del nodo
     */
    public NodoHash getDirMemDer() {
        return dirMemDer;
    }

    /**
     * Cambia la clave del nodo
     * @param clave valor por el cual se va a cambiar la clave
     */
    public void setClave(Object clave) {
        this.clave = clave;
    }

    /**
     * Cambia el valor que contiene
     * @param valor valor nuevo que por el cual se va a cambiar
     */
    public void setValor(Object valor) {
        this.valor = valor;
    }

    /**
     * Cambia el apuntador derecho del nodo
     * @param dirMemDer Nodo al que va apuntar el nodo
     */
    public void setDirMemDer(NodoHash dirMemDer) {
        this.dirMemDer = dirMemDer;
    }

    @Override
    public String toString() {
        return clave+"";
    }
}
