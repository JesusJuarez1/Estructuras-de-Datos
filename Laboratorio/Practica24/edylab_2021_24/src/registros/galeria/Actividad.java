package registros.galeria;

/**
 * Clase que simula ser una actividad, almacenando el pintor que la realiza.
 * @author Jesus
 * @version 1.0
 */
public class Actividad {
    protected Pintor pintor;
    protected String nombre;

    public Actividad(Pintor pintor,String nombre){
        this.pintor = pintor;
        this.nombre = nombre;
    }

    public String toString(){
        return pintor.toString()+", "+nombre;
    }
}
