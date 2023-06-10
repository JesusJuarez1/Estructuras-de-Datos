package estructuraslineales.registros;

/**
 * Nodo el cual contiene una direcion a sus hijos izquierda y derecha y tambien una direccion al padre de dicho nodo,
 * ademas del espacio para almacenar el objeto del nodo.
 * @author Jesus
 * @version 1.0
 */
public class NodoTriple {
    protected NodoTriple padre;
    protected Object elemento;
    protected NodoTriple hijoIzq;
    protected NodoTriple hijoDer;

    public NodoTriple(Object elemento){
        padre=null;
        this.elemento=elemento;
        hijoIzq=null;
        hijoDer=null;
    }

    /**
     * Obtiene el padre del nodo
     * @return El padre del nodo
     */
    public NodoTriple getPadre() {
        return padre;
    }

    /**
     * Cambia el padre del nodo
     * @param padre Nuevo padre del nodo
     */
    public void setPadre(NodoTriple padre) {
        this.padre = padre;
    }

    /**
     * Obtiene el elemento del nodo
     * @return Elemento del nodo
     */
    public Object getElemento() {
        return elemento;
    }

    /**
     * Cambia el elemento del nodo
     * @param elemento Nuevo elemento del nodo
     */
    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    /**
     * Obtiene el hijo izquierdo del nodo
     * @return Hijo izquierdo
     */
    public NodoTriple getHijoIzq() {
        return hijoIzq;
    }

    /**
     * Cambia el nodo izquierdo del nodo
     * @param hijoIzq Nuevo nodo izquierdo
     */
    public void setHijoIzq(NodoTriple hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    /**
     * Obtiene el hijo derecho del nodo
     * @return El hijo derecho del nodo
     */
    public NodoTriple getHijoDer() {
        return hijoDer;
    }

    /**
     * Cambia el hijo derecho del nodo por el pasado
     * @param hijoDer Nuevo hijo derecho
     */
    public void setHijoDer(NodoTriple hijoDer) {
        this.hijoDer = hijoDer;
    }

    /**
     * Obtiene el toString del elemento
     * @return Lo que regrese el toString del elemento
     */
    public String toString(){
        return elemento.toString();
    }
}
