package registros.ferreteria;

/**
 * Enumerado que contiene el menu principal de la ferreteria
 * @author Jesus
 * @version 1.0
 */
public enum MenuFerreteria {
    AGREGAR("Agregar Producto",1),
    CONSULTAR("Listar catalogo completo",2),
    BUSCARMARCA("Buscar un producto a partir de la marca",3),
    BUSPRODES("Buscar producto con base a una palabra en la descripcion",4),
    ELIMINAR("Eliminar producto",5),
    CAMBIARPRECIO("Cambiar el precio del producto",6),
    CAMBIARDES("Cambiar descripcion del producto",7),
    BUSCARPAGINAS("Buscar productos que estan entre las paginas",8),
    SALIR("Salir",9);

    private String nombre;
    private int indice;
    private MenuFerreteria(String nombre, int indice){
        this.nombre = nombre;
        this.indice = indice;
    }

    /**
     * Obtiene el nombre de la opcion
     * @return El nombre de la opcoion
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Obtiene el indice de la opcion
     * @return El indice de la opcion
     */
    public int getIndice() {
        return indice;
    }
}
