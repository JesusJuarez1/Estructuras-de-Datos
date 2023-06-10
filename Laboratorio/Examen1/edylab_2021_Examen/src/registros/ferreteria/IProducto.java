package registros.ferreteria;

/**
 * Clase que contiene toda la funcionalidad de Producto
 * @author Jesus
 * @version 1.0
 */
public interface IProducto {

    /**
     * Obtiene el nombre del producto
     * @return nombre
     */
    public String getNombre();

    /**
     * Cambia el nombre del producto
     * @param nombre nombre nuevo
     */
    public void setNombre(String nombre);

    /**
     * Obtiene la descripcion del producto
     * @return descripcion
     */
    public String getDescripcion();

    /**
     * Cambia la descripcion del producto
     * @param descripcion descripcion nueva
     */
    public void setDescripcion(String descripcion);

    /**
     * Obtiene el precio del producto
     * @return precio
     */
    public double getPrecio();

    /**
     * Cambia el precio del producto
     * @param precio nuevo precio
     */
    public void setPrecio(double precio);

    /**
     * Obtiene la pagina donde esta el producto en el catalogo
     * @return pagina
     */
    public int getPagina();

    /**
     * Cambia la pagina en la que esta el producto en el catalogo
     * @param pagina nuevo numero de pagina
     */
    public void setPagina(int pagina);

    /**
     * Agrega una marca al arreglo ordenado marcas
     * @param marca nueva marca a agregar
     * @return true si lo hace, false en caso contrario
     */
    public boolean agregarMarca(String marca);

    /**
     * Regresa una cadena con formato para imprimri en pantalla
     * @return Una cadena con los atributos de nombre, descripcion y precio
     */
    public String toStringObjeto();

}
