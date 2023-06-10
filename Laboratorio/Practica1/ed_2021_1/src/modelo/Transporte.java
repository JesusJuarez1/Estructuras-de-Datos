package modelo;

public class Transporte {
    protected Vehiculo vehiculo;
    protected Locacion origen;
    protected Locacion destino;
    protected Chofer chofer;
    protected Material material;
    protected boolean entregado;

    public Transporte(Vehiculo vehiculo, Locacion origen, Locacion destino, Chofer chofer, Material material, boolean entregado) {
        this.vehiculo = vehiculo;
        this.origen = origen;
        this.destino = destino;
        this.chofer = chofer;
        this.material = material;
        this.entregado = entregado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Locacion getOrigen() {
        return origen;
    }

    public void setOrigen(Locacion origen) {
        this.origen = origen;
    }

    public Locacion getDestino() {
        return destino;
    }

    public void setDestino(Locacion destino) {
        this.destino = destino;
    }

    public Chofer getChofer() {
        return chofer;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    @Override
    public String toString() {
        return "Transporte{" +
                "vehiculo=" + vehiculo +
                ", origen=" + origen +
                ", destino=" + destino +
                ", chofer=" + chofer +
                ", material=" + material +
                ", entregado=" + entregado +
                '}';
    }
}
