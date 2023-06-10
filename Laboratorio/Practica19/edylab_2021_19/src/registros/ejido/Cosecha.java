package registros.ejido;

/**
 * Esta clase simula ser una cosecha la cual guardara el nombre de la cosecha y las toneladas
 * @author Jesus
 * @version 1.0
 */
public class Cosecha implements ICosecha{
    protected String nombre;
    protected double toneladas;

    public Cosecha(String nombre, double toneladas){
        this.nombre = nombre;
        this.toneladas = toneladas;
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
    public double getToneladas() {
        return toneladas;
    }

    @Override
    public void setToneladas(double toneladas) {
        this.toneladas = toneladas;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
