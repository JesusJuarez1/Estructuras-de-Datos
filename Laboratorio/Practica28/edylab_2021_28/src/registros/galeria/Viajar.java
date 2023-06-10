package registros.galeria;

/**
 * Actividad Viajar
 * @author Jesus
 * @version 1.0
 */
public class Viajar extends Actividad{
    protected String lugar;

    public Viajar(Pintor pintor, String lugar) {
        super(pintor,"Viajar");
        this.lugar = lugar;
    }

    public String toString(){
        return super.toString()+",\n"+lugar;
    }
}
