package registros.ferreteria;

/**
 * Contiene toda la funcionalidad de Ferreteria
 * @author Jesus
 * @version 1.0
 */
public interface IFerreteria {

    /**
     * Contiene el menu con el cual usar el programa
     */
    public void menu();

    /**
     * Agrega un producto al arreglo catalogo
     * @param p Prodcuto a agregar
     * @return true si lo hizo, false en caso contrario
     */
    public boolean agregarProducto(Producto p);

    /**
     * Modifica las paginas de los productos en base al catalogo, cada 2 productos es una nueva pagina
     */
    public void asignarPaginas();

    /**
     * Imprime el catalogo completo
     */
    public void imprimirCatalogo();

    /**
     * Busca e imprime los productos con la marca dada
     * @param marca nombre de la marca a buscar
     */
    public void buscarProductoMarca(String marca);

    /**
     * Busca si la descripcion de un producto incluye la palabra dada como parametro
     * @param txt palabra a buscar en la descripcion de los productos
     */
    public void buscarProPalabraDescripcion(String txt);

    /**
     * Busca un prodcuto en el catalogo y regresa la posicion
     * @param accion Accion que se hara
     * @return la posicion+1, 0 si se cancela o esta vacio el catalogo
     */
    public int buscarProducto(String accion);

    /**
     * Elimina un producto del catalogo a partir del indice
     * @param posicion posicion del producto a eliminar
     */
    public void eliminarProducto(int posicion);

    /**
     * Imprime en pantalla los prodcutos que esten entre la pag1 y pag2 incluyendolas
     * @param pag1 pagina inicio
     * @param pag2 pagina final
     */
    public void productosEntrePaginas(int pag1,int pag2);
}
