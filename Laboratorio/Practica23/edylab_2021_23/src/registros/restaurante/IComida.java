package registros.restaurante;

/**
 * Interface de la clase comida
 * @author Jesus
 * @version 1.0
 */
public interface IComida {
    /**
     * Agrega ingredientes a la lista de ingredientes de la comida
     */
    public void agregarIngredientes();

    /**
     * Regresa todos los atributos de la comida en una sola cadena de texto
     * @return Una cadena de texto con todos los atributos de la comida
     */
    public String comida();

    /**
     * Elimina ingredientes seleccionados por el usuario
     */
    public void eliminarIngredientes();

    /**
     * Imprime la comida que tenga el ingrediente pasado como parametro
     * @param nombre Nombre del ingrediente
     */
    public void comidaConIngrediente(String nombre);
}
