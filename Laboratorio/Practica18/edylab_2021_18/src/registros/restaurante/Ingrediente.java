package registros.restaurante;

/**
 * Clase que almacena los atributos pricipales de un ingrediente de una comida
 */
public class Ingrediente implements IIngrediente{
    protected String nombre;
    protected String descripcion;
    protected int cantidad;
    protected TipoIngrediente tipo;

    public Ingrediente(String nombre, String descripcion, int cantidad, TipoIngrediente tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }

    @Override
    public String ingrediente(){
        return nombre+": "+descripcion+", cantidad: "+cantidad+", Tipo: "+tipo;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
