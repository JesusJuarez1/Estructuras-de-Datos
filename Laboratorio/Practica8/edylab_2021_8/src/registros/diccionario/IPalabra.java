package registros.diccionario;

/**
 * Clase que contiene todas las operaciones de Palabra
 * @author Jesus
 * @version 1.0
 */
public interface IPalabra {

    /**
     * Obtiene la definicion de la palabra
     * @return La definicion
     */
    public String getDefinicion();

    /**
     * Concatena los atributos del objeto
     * @return Una cadena de texto que contiene los atributos del objeto
     */
    public String toStringObjeto();
}
