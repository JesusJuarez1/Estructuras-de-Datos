package registros.galeria;

/**
 * Actividad de Exponer
 * @author Jesus
 * @version 1.0
 */
public class Exponer extends Actividad{
    protected String nombre_evento;
    protected String lugar;
    protected String fecha;
    protected int aforo;

    public Exponer(Pintor pintor,String nombre_evento, String lugar, String fecha, int aforo) {
        super(pintor,"Exponer");
        this.nombre_evento = nombre_evento;
        this.lugar = lugar;
        this.fecha = fecha;
        this.aforo = aforo;
    }

    public String toString(){
        return super.toString()+"\n"+nombre_evento+", "+lugar+", "+fecha+", "+aforo;
    }
}
