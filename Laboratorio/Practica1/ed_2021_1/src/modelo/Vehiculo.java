package modelo;

public class Vehiculo {
    protected int numSerie;
    protected TipoVehiculo tipo;

    public Vehiculo(int numSerie, TipoVehiculo tipo){
        this.numSerie = numSerie;
        this.tipo = tipo;
    }

    public int getNumSerie() {
        return numSerie;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Vehiculo: "+numSerie+", Tipo: "+tipo.toString();
    }
}
