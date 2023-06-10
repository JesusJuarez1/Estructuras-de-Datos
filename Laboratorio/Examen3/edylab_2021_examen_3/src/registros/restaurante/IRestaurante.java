package registros.restaurante;

/**
 * Interface de la clase Restaurante
 * @author Jesus
 * @version 1.0
 */
public interface IRestaurante {

    /**
     * Agrega una comida a la lista
     */
    public void agregarComida();

    /**
     * Imprime los nombres de las comidas (menu de platillos para el cliente)
     */
    public void menuPlatillos();

    /**
     * Imprime todas las comidas junto con sus ingredientes
     */
    public void comidasIngredientes();

    /**
     * Busca la comida con el nombre indicado e imprime sus ingredientes
     * @param nombre Nombre de la comida a buscar
     * @return true si existe la comida, false en caso contrario
     */
    public boolean ingredientesComida(String nombre);

    /**
     * Dado el nombre de una comida, ingresar nuevos ingredientes a esa comida
     * @param nombre Nombre de la comida a agregar ingredientes
     */
    public void agregarIngredientes(String nombre);

    /**
     * Busca la comida a la cual se le quiere eliminar ingredientes
     * @param nombre Nombre de la comida
     */
    public void eliminarIngredientes(String nombre);

    /**
     * Da la opcion de eliminar alguna comida
     */
    public void eliminarComida();

    /**
     * Recorre la lista de comidas e invoca el metodo de comidasConIngredientes dentro de la clase Comida
     * @param nombre Nombre del ingrediente
     */
    public void comidasConIngrediente(String nombre);

    /**
     * Imprime las comidas que sean del chef escojido
     * @param nombre Nombre del cocinero
     */
    public void comidasDelChef(String nombre);

    /**
     * Muestra los platillos que requieren mas de "cantidad" de gramos
     * @param cantidad Cantidad de gramos de ingredientes
     */
    public void platillosConMas(int cantidad);

    /**
     * Evalua que platillos requieren ingredientes de algun tipo
     * @param tipo Tipo de ingrediente a evaluar
     */
    public void comidaConIngTipo(TipoIngrediente tipo);

    /**
     * Imprime los platillos de un tipo dado
     * @param tipo Tipo de platillos a imprimir
     */
    public void platillosTipo(TipoComida tipo);

    /**
     * Elimina los platillos que son de un tipo
     * @param tipo Tipo comida a eliminar
     */
    public void eliminarPlatillosTipo(TipoComida tipo);
}
