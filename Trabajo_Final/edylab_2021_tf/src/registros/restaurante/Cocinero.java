package registros.restaurante;

/**
 * Clase que almacena el nombre de un cocinero
 */
public class Cocinero {
    protected String nombre;

    public Cocinero(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return nombre;
    }
}
