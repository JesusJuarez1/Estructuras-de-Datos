package registros.proceso;

/**
 * Enumerado el cual determina la prioridad del proceso
 */
public enum TipoProceso {
    SISTEMA(1),
    DESCARGA(2),
    GUARDADO(3),
    ABRIR(4),
    CERRAR(5),
    IMPRESION(6),
    COPIADO(7),
    PEGADO(8);

    private int prioridad;

    private TipoProceso(int prioridad){
        this.prioridad = prioridad;
    }

    /**
     * obtiene la prioridad del proceso
     * @return Regresa la prioridad del proceso
     */
    public int getPrioridad() {
        return prioridad;
    }

    /**
     * Concatena en una cadena la palabra Prioridad con el la prioridad del proceso
     * @return La cadena
     */
    public String toString(){
        return ""+prioridad;
    }
}
