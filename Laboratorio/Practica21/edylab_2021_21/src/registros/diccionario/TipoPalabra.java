package registros.diccionario;

/**
 * Enumerado que contiene los tipos de palabras
 * @author Jesus
 * @version 1.0
 */
public enum TipoPalabra {
    VERBO("Verbo",1),
    ADJETIVO("Adjetivo",2),
    SUSTANTIVO("Sustantivo",3),
    ADVERBIO("Advervio",4),
    PREPOSICION("Preposicion",5);

    private String nombre;
    private int indice;

    private TipoPalabra(String nombre, int indice){
        this.nombre = nombre;
        this.indice = indice;
    }

    /**
     * Obtiene el nombre del tipo de palabra
     * @return Regresa el nombre de la opcion
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Obtiene el indice del tipo de palabra
     * @return Regresa el indice de la opcion
     */
    public int getIndice() { return indice; }
}
