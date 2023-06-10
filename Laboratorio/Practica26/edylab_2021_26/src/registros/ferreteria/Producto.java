package registros.ferreteria;

import estructuraslineales.ArregloOrden;
import estructuraslineales.TipoOrden;

/**
 * Clase que simula ser un producto de ferreteria
 * @author Jesus
 * @version 1.0
 */
public class Producto implements IProducto{
    protected String nombre;
    protected String descripcion;
    protected double precio;
    protected ArregloOrden marcas;
    protected boolean fotografia;
    protected int pagina;

    public Producto(String nombre, String descripcion, double precio, boolean fotografia, int numMarcas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fotografia = fotografia;
        marcas = new ArregloOrden(numMarcas, TipoOrden.ASCENDENTE);
    }

    public Producto(String nombre, String descripcion,double precio,boolean fotografia,ArregloOrden marcas){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fotografia = fotografia;
        this.marcas = marcas;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public int getPagina() {
        return pagina;
    }

    @Override
    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    @Override
    public boolean agregarMarca(String marca){
        if(marcas.agregar(marca) != -1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString(){
        return nombre;
    }

    @Override
    public String toStringObjeto(){
        return nombre+": "+descripcion+". $"+precio;
    }
}
