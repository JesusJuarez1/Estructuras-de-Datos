package registros.galeria;

/**
 * Actividad de pintar
 * @author Jesus
 * @version 1.0
 */
public class Pintar extends Actividad{
    protected String nombre_evento;

    public Pintar(Pintor pintor,String nombre_evento){
        super(pintor,"Pintar");
        this.nombre_evento = nombre_evento;
    }

    public String toString(){
        return super.toString()+"\n, "+nombre_evento;
    }
}
