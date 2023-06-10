package registros.galeria;

public class Firma_Autografo extends Actividad{
    protected String lugar;
    protected String fecha;

    public Firma_Autografo(Pintor pintor, String lugar, String fecha){
        super(pintor,"Firma de Autografos");
        this.lugar = lugar;
        this.fecha = fecha;
    }

    public String toString(){
        return super.toString()+"\n, "+lugar+", "+fecha;
    }
}
