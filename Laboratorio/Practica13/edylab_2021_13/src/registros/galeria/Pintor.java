package registros.galeria;

/**
 * Clase que contiene todos los atributos y funcionalidad de un pintor
 * @author Jesus
 * @version 1.0
 */
public class Pintor {
    protected String nombre;
    protected int edad;
    protected String fecha_nac;
    protected String domicilio;
    protected String rfc;
    protected String nivel_edu;

    public Pintor(String nombre, int edad, String fecha_nac, String domicilio, String rfc, String nivel_edu) {
        this.nombre = nombre;
        this.edad = edad;
        this.fecha_nac = fecha_nac;
        this.domicilio = domicilio;
        this.rfc = rfc;
        this.nivel_edu = nivel_edu;
    }

    @Override
    public String toString(){
        return nombre+", "+edad+", "+fecha_nac+", "+rfc;
    }
}
